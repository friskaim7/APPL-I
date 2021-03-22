import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CopyFile {
    public static void main(String[] args) {
        String fileName;
        do {
            System.out.print("Enter a file path : ");
            Scanner fileNameScanner = new Scanner(System.in);
            fileName = fileNameScanner.nextLine();
            try {
                File file = new File(fileName);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine())
                    System.out.println(fileScanner.nextLine());
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found. Please try again.");
                fileName = "";
            }
        } while (fileName.isEmpty());
    }
}