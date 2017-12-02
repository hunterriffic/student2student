import java.sql.*;

public class Dbconnection {
    private static String url = "jdbc:driver://student2student.ci7oiohekotg.us-east-1.rds.amazonaws.com:3306/student2student?user=wareagle&password=rolltide";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "wareagle";
    private static String password = "rolltide";
    private static Connection con;
    private static String urlstring;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlstring, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
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