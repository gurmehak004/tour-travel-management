package travel.management.system;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
     String URL = "jdbc:mysql://localhost:3306/travelmanagementsystem"; // Replace localhost if needed
     String USER = "root";  // Change to your MySQL username
     String PASSWORD = "mehak@012";  // Change to your MySQL password

    
//    public static Connection connect() {
//        Connection conn = null;
    public Conn() {
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
            c = DriverManager.getConnection(URL, USER, PASSWORD);
            s=c.createStatement();
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
//        return c;
    }

    public static void main(String[] args) {
//        Connection conn = connect();
//        if (c != null) {
            System.out.println("Connection established!");
    }
} 
//    }
//}
