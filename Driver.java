import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Driver {

    public static void main (String[] args) {

        Scanner scan = new Scanner (System.in);

        int userSelection = -1;

        while (userSelection == -1) {

            System.out.println("Welcome to Student2Student!");


            System.out.println("Please enter the number of your selection.");
            System.out.println("\tMenu :");
            System.out.println("\t\t1: Browse Jobs");
            System.out.println("\t\t2: Browse Projects");
            System.out.println("\t\t3: Browse Clubs");
            System.out.println("\t\t4: Manage Data");
            System.out.println("\t\t-1: Quit");

            userSelection = scan.nextInt();

            if(userSelection == 1) {

                // start browsing jobs
                System.out.println("Beginning job search...");
                //ProviderTerminal terminal = new ProviderTerminal();
                //terminal.start();
                userSelection = -1;


<<<<<<< HEAD
=======
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        new AutocompleteGUI(10).setVisible(true);
//                    }
//                });
//

>>>>>>> 791511079c8698ed7cd45e80677238af9662c4b2
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new SearchGUI(10).setVisible(true);
                    }
                });
<<<<<<< HEAD
=======


>>>>>>> 791511079c8698ed7cd45e80677238af9662c4b2
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
                // manage tags and users
                System.out.println("Opening data manager...");
                DataManager manager = new DataManager();
                manager.mainMenu();
            }
            else {
                userSelection = -1;
                System.out.println("ERROR: That was not a valid selection. Please try again.");
            }
        }
     }
}

