import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductReader {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser(".");
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            Path filePath = chooser.getSelectedFile().toPath();

            // Print headers
            System.out.printf("%-10s %-15s %-25s %-8s%n",
                    "ID#", "Name", "Description", "Cost");
            System.out.println("====================================================");

            try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String description = parts[2].trim();
                    String cost = parts[3].trim();

                    System.out.printf("%-10s %-15s %-25s %-8s%n",
                            id, name, description, cost);
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
