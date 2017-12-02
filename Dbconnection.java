import java.sql.*;

public class Dbconnection {
//     private static String url = "jdbc:driver://student2student.ci7oiohekotg.us-east-1.rds.amazonaws.com:3306/student2student?user=wareagle&password=rolltide";
//     private static String driverName = "mysql-connector.jar";
//     private static String username = "wareagle";
//     private static String password = "rolltide";
//     static Connection con;
//     private static String urlstring;
//
//     public static Connection getConnection() {
//         try {
//             Class.forName(driverName);
//             try {
//                 con = DriverManager.getConnection(urlstring, username, password);
//             } catch (SQLException ex) {
//                 // log an exception. fro example:
//                 System.out.println("Failed to create the database connection.");
//             }
//         } catch (ClassNotFoundException ex) {
//             // log an exception. for example:
//             System.out.println("Driver not found.");
//         }
//         return con;
//     }
// }
//


	System.out.println("-------- MySQL JDBC Connection Testing ------------");

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}

	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;

	try {
		connection = DriverManager
		.getConnection("jdbc:student2student://ci7oiohekotg.us-east-1.rds.amazonaws.com:3306/student2student","wareagle", "rolltide");

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}

	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
  }
}

//STEPS TO MAKE DATABASE QUERIES
//        Statement stmt = null;
//        String query = "select COF_NAME, SUP_ID, PRICE, " +
//        "SALES, TOTAL " +
//        "from " + dbName + ".COFFEES";
//        try {
//          stmt = con.createStatement();
//          ResultSet rs = stmt.executeQuery(query);
//        while (rs.next()) {
//          String coffeeName = rs.getString("COF_NAME");
//          int supplierID = rs.getInt("SUP_ID");
//          float price = rs.getFloat("PRICE");
//          int sales = rs.getInt("SALES");
//          int total = rs.getInt("TOTAL");
//          System.out.println(coffeeName + "\t" + supplierID +
//        "\t" + price + "\t" + sales +
//        "\t" + total);
//        }
//        } catch (SQLException e ) {
//        JDBCTutorialUtilities.printSQLException(e);
//        } finally {
//        if (stmt != null) { stmt.close(); }
//        }
//        }
