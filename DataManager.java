import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
	ArrayList<User> users;

    Scanner scan = new Scanner(System.in);

    public DataManager() {

    }

    public void mainMenu() {

        boolean keepRunning = true;

        System.out.println("Welcome to the Data Manager!");
        	System.out.println("Menu: ");
        System.out.println("   1: Create New User");
        System.out.println("   2: Update User Tags");
        System.out.println("   3: Create New Entry");
        System.out.println("   4: Update Entry Tags");
        System.out.println("   5: View all users");
        System.out.println("   6: View all entries");
        System.out.println("   7: View all tags");
        System.out.println("   -1: Quit");

        switch (scan.nextLine()) {
            case "1" : createUser(); break;
            case "2" : updateUserTags(); break;
            case "3" : createEntry(); break;
            case "4" : updateEntryTags(); break;
            case "5" : viewAllUsers(); break;
            case "6" : viewAllEntries(); break;
            case "7" : viewAllTags(); break;
            case "-1" : keepRunning = false; break;
            default: ;
        }
        if (keepRunning) mainMenu();

    }
   
    private void createUser() {

    		System.out.println("Please enter the name of the User in the format: FirstnameLastname.");
        String name = scan.nextLine();
        System.out.println(name);
       
        System.out.println("Is this correct? Y/N");
        String inputContinue = scan.nextLine();

        if(inputContinue.toLowerCase().equals("y")) {
            ArrayList<Tag> tempTags = null;
			User toAdd = new User(name, tempTags);
            toAdd.name = name;
            users.add(toAdd);
            System.out.println("New User created.");

        }
        else {
            System.out.println("Do you want to retry creating a new member? Y/N");
            String inputCont2 = scan.nextLine();
            if(inputCont2.toLowerCase().equals("y")) {
                createUser();
            }
            else {
                mainMenu();
            }
        }
    }
    
    private void updateUserTags() {
    		System.out.println("Enter the name of the User to change in format: FirstnameLastname.");
    		String name = scan.nextLine();
    		System.out.println(name);
    		
    		System.out.println("Is this correct? Y/N");
        String inputContinue = scan.nextLine();
    		
    }
}
