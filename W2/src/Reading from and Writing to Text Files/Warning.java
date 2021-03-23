
// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;

public class Warning {
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main(String[] args) {
        int creditHrs; // number of semester hours earned
        double qualityPts; // number of quality points earned
        double gpa; // grade point (quality point) average
        String line, name, inputName = "students.dat";
        String outputName = "warning.dat";
        try {
            // Set up scanner to input file
            File file = new File(inputName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(" ");

            // Set up the output file stream
            PrintWriter outFile = new PrintWriter(outputName);

            // Print a header to the output file
            outFile.println();
            outFile.println("Students on Academic Warning");
            outFile.println();

            // Process the input file, one token at a time
            while (scanner.hasNextLine()) {
                // Get the credit hours and quality points and
                // determine if the student is on warning. If so,
                // write the student data to the output file.
                String[] column = scanner.nextLine().split(" ", 0);
                name = column[0];
                qualityPts = Double.parseDouble(column[2]);
                creditHrs = Integer.parseInt(column[1]);
                gpa = qualityPts / creditHrs;

                if (((gpa < 1.5) && (creditHrs < 30)) || ((gpa < 1.75) && (creditHrs < 60)) || (gpa < 2.0))
                    outFile.println(name + " " + creditHrs + " " + gpa);
            }
            // Close output file
            outFile.close();
        } catch (Exception exception) {
            if (exception instanceof FileNotFoundException)
                System.out.println("The file " + inputName + " was not found.");
            else if (exception instanceof IOException)
                System.out.println(exception);
            else if (exception instanceof NumberFormatException)
                System.out.println("Format error in input file: " + exception);
        }
    }
}