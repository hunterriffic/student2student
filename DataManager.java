import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
	ArrayList<User> users;
	ArrayList<Entry> entries;

    Scanner scan = new Scanner(System.in);

    public DataManager() {

    }

    public void mainMenu() {

        boolean keepRunning = true;

        System.out.println("Welcome to the Data Manager!");
        	System.out.println("Menu: ");
        System.out.println("	1: Create New User");
        System.out.println("	2: Create New Entry");
        System.out.println("	3: Update Entry Tags");
        System.out.println("	4: View all users");
        System.out.println("	5: View all entries");
        System.out.println("	6: View all tags");
        System.out.println("	-1: Quit");

        switch (scan.nextLine()) {
            case "1" : createUser(); break;
            case "2" : createEntry(); break;
//            case "3" : updateEntryTags(); break;
//            case "4" : viewAllUsers(); break;
//            case "5" : viewAllEntries(); break;
//            case "6" : viewAllTags(); break;
            case "-1" : keepRunning = false; break;
            default: ;
        }
        if (keepRunning) mainMenu();

    }
   
    private void createUser() {
    		String tempName = null;
    		User toAdd = new User(tempName);
    		
    		System.out.println("Please enter the name of the User in the format: FirstnameLastname.");
        String name = scan.nextLine();
        //System.out.println(name);
       
        System.out.println("Is " + name + " correct? Y/N");
        String inputContinue = scan.nextLine();

        if(inputContinue.toLowerCase().equals("y")) {
        		System.out.println("if statement entered");
            toAdd.name = name;
            System.out.println("changed name in toAdd");
            //users.add(toAdd);
            System.out.println("going to database");
            //Statement stmt;
            String query = "INSERT INTO student2student.users (username, email, password, cell, major)\n" + 
            		"VALUES (" + toAdd.name + ")";
            System.out.println("just before try");
            try {
				Statement stmt = Dbconnection.getConnection().createStatement();
				System.out.println("passed through first stmt");
				ResultSet rs = stmt.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("New User created.");

        }
        else {
            System.out.println("Do you want to retry creating a new user? Y/N");
            String inputCont2 = scan.nextLine();
            if(inputCont2.toLowerCase().equals("y")) {
                createUser();
            }
            else {
                mainMenu();
            }
        }
    }
    
    private void createEntry() {
		System.out.println("Please enter the name of the Entry without spaces.");
        String name = scan.nextLine();
        System.out.println("Please enter a brief description of this entry.");
        String description = scan.nextLine();
        System.out.println("Please enter the name of the creator in the format: FirstnameLastname");
        String creatorName = scan.nextLine();
        
        String tempName = null;
        
        User creator = new User(tempName);
        int userIndex = users.indexOf(creatorName);
        if (userIndex != -1) {
        		creator = users.get(userIndex);
        }
        else {
        		System.out.println("User not found. Please try again.");
        		
        }
        
        System.out.println(name + " | ");
        System.out.println(description + " | " + creator.getName());
        
        System.out.println("Is this correct? Y/N");
        String inputContinue = scan.nextLine();

        if(inputContinue.toLowerCase().equals("y")) {
            ArrayList<Tag> tempTags = null;
			Entry toAdd = new Entry(name, description, creator, tempTags);
            toAdd.entryName = name;
            entries.add(toAdd);
            Statement stmt = null;
            String query = "INSERT INTO student2student.entries (name, description, creator)\n" + 
            		"VALUES (" + toAdd.entryName + ")";
            try {
				stmt = Dbconnection.con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
}
