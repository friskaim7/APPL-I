
// ****************************************************************
// IntegerListTest.java
//
// Provide a menu-driven tester for the IntegerList class.
//
// ****************************************************************
import java.util.Scanner;

public class IntegerListTest {
    static IntegerList list = new IntegerList(10);
    static Scanner scan = new Scanner(System.in);

    // -------------------------------------------------------
    // Create a list, then repeatedly print the menu and do what the
    // user asks until they quit
    // -------------------------------------------------------
    public static void main(String[] args) {
        printMenu();
        int choice = scan.nextInt();
        while (choice != 0) {
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
        }
    }

    // -------------------------------------------------------
    // Do what the menu item calls for
    // -------------------------------------------------------
    public static void dispatch(int choice) {
        int loc;
        switch (choice) {
        case 0:
            System.out.println("Bye!");
            break;

        case 1:
            System.out.println("How big should the list be?");
            int size = scan.nextInt();
            list = new IntegerList(size);
            list.randomize();
            break;

        case 2:
            list.replaceAll();
            break;
        
        case 3:
            list.selectionSort();
            break;
        
        case 4:
            list.sortDecreasing();
            break;

        case 5:
            System.out.print("Enter the value to look for: ");
            loc = list.search(scan.nextInt());

            if (loc != -1)
                System.out.println("Found at location " + loc);
            else
                System.out.println("Not in list");
            break;

        case 6:
            System.out.print("Enter the value to look for: ");
            loc = list.binarySearchD(scan.nextInt());

            if (loc != -1)
                System.out.println("Found at location " + loc);
            else
                System.out.println("Not in list");
            break;

        case 7:
            list.print();
            break;

        default:
            System.out.println("Sorry, invalid choice");
        }
    }

    // -------------------------------------------------------
    // Print the user's choices
    // -------------------------------------------------------
    public static void printMenu() {
        System.out.println("\n Menu ");
        System.out.println(" ====");
        System.out.println("0: Quit");
        System.out.println("1: Create a new list (** do this first!! **)");
        System.out.println("2: Replace All()");
        System.out.println("3: Sort the list using selection sort");
        System.out.println("4: Sort the list using selection sort (decreasing)");
        System.out.println("5: Find an element in the list using linear search");
        System.out.println("6: Find an element in the list using binary search");
        System.out.println("7: Print the list");
        System.out.print("\nEnter your choice: ");
    }
}