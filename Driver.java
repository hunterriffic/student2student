import java.util.Scanner;

public class Driver {

    public static void main (String[] args) {

        Scanner scan = new Scanner (System.in);

        int userSelection = -1;

        while (userSelection == -1) {

            System.out.println("Welcome to Student2Student!");


            System.out.println(" Please enter the number of your selection.     ");
            System.out.println("    Menu :                                      ");
            System.out.println("       1: Browse Jobs                           ");
            System.out.println("       2: Browse Projects                       ");
            System.out.println("       3: Browse Clubs                          ");
            System.out.println("       4: Manage Tags                           ");
            System.out.println("       -1: Quit                                 ");

            userSelection = scan.nextInt();

            if(userSelection == 1) {

                // start browsing jobs
                System.out.println("Beginning job search...");
                //ProviderTerminal terminal = new ProviderTerminal();
                //terminal.start();
                userSelection = -1;

            }
            else if( userSelection == 2) {
                // start browsing projects
                System.out.println("Beginning project search...");
                //OperatorInterface terminal = new OperatorInterface();
                //terminal.mainMenu();
                userSelection = -1;
            }
            else if (userSelection == 3) {
                // start browsing clubs
                System.out.println("Beginning club search...");
            }
            else if(userSelection == -1) {
                System.out.println("Thank you for using Student2Student!");
            }
            else if(userSelection == 4) {
                // manage tags
                System.out.println("Opening tag manager...");
            }
            else {
                userSelection = -1;
                System.out.println("ERROR: That was not a valid selection. Please try again.");
            }
        }
    }
