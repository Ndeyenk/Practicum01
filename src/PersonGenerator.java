import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> people = new ArrayList<>();
        boolean moreData = true;

        while (moreData) {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID:");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name:");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name:");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title:");
            int yob = SafeInput.getInt(in, "Enter Year of Birth:");

            people.add(id + ", " + firstName + ", " + lastName + ", " + title + ", " + yob);

            moreData = SafeInput.getYNConfirm(in, "Add another person? (Y/N)");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter filename (example: PersonTestData.txt):");
        Path filePath = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (String person : people) {
                writer.write(person);
                writer.newLine();
            }
            System.out.println("File saved as " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
