/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whowantstobemillionaire;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author ashwinkasoju
 */
public class UserDAO {
    
    //this class handles all user-related DB connections 
    //need connection string, Id, password to connect to our DB
    private static final String CONNECTION_URL = "jdbc:derby://localhost:1527/millionaire;create=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public boolean saveUser(String firstName, String lastName, int age, String userId, String password) {
        System.out.println("\nsave user is called with these values: \n");
        System.out.println("firstName: "+firstName+" lastName: "+lastName+" age: "+age+" userId: "+userId+" password: "+password);
        try (Connection conn = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD)) {
            // Use the correct column name USER_ID
            String sql = "INSERT INTO users (first_name, last_name, age, user_id, password) VALUES (?, ?, ?, ?, ?)";  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, age);
            pstmt.setString(4, userId);
            pstmt.setString(5, password);
            pstmt.executeUpdate(); // Executing the DB operation
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saving user: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public boolean authenticate(String userID, String password) { // Method to validate user credentials -> id and password
        try (Connection conn = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD)) {
            // Use the correct column name USER_ID
            String sql = "SELECT * FROM users WHERE user_id = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID); // Sending in user id
            pstmt.setString(2, password); // Sending in user password
            ResultSet rs = pstmt.executeQuery(); // Hitting DB
            return rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace(); // Using catch just in case it throws an error
            return false;
        }
    }
}
