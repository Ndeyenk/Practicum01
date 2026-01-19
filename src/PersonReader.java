import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersonReader {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser(".");
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            Path filePath = chooser.getSelectedFile().toPath();

            System.out.printf("%-10s %-12s %-12s %-8s %-6s%n",
                    "ID#", "FirstName", "LastName", "Title", "YOB");
            System.out.println("==============================================");

            try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    String id = parts[0].trim();
                    String first = parts[1].trim();
                    String last = parts[2].trim();
                    String title = parts[3].trim();
                    String yob = parts[4].trim();

                    System.out.printf("%-10s %-12s %-12s %-8s %-6s%n",
                            id, first, last, title, yob);
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
