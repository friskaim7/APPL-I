import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CopyFile {
    public static void main(String[] args) {
        String fileName = "";
        Scanner fileNameScanner = new Scanner(System.in);
        while (fileName.isEmpty()) {
            System.out.print("Enter a file path : ");
            fileName = fileNameScanner.nextLine();
            try {
                File file = new File(fileName);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine())
                    System.out.println(fileScanner.nextLine());
                fileScanner.close();
                fileNameScanner.close();
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found. Please try again.");
                fileName = "";
            }
        }
    }
}