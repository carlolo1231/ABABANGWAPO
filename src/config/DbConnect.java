package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnect {
    private Connection connect;

    public DbConnect() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/supplytracker_db", "root", "");
            System.out.println("Connected to database successfully!");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }

    
    public Connection getConnection() {
        return connect;
    }

    public int insertUser(String fname, String lname, String contactnum, String email,String UserType, String reguser, String regpass) {
        int result = 0; 
        String sql = "INSERT INTO users (fn, ln, cn, em,type, us, ps, status) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, contactnum);
            pst.setString(4, email);
            pst.setString(5, UserType);
            pst.setString(6, reguser);
            pst.setString(7, regpass);
            pst.setString(8, "Pending");

            result = pst.executeUpdate();
            System.out.println("User inserted successfully with 'Pending' status!");
        } catch (SQLException ex) {
            System.out.println("Insert Error: " + ex.getMessage());
        }
        return result;
    }
    
public ResultSet getData(String query) {
    ResultSet rs = null;
    try {
        PreparedStatement pst = connect.prepareStatement(query);
        rs = pst.executeQuery();
    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex.getMessage());
    }
    return rs;
}
public boolean insertData(String sql){
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
               return true;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
               return false;
            }
        }
public boolean isEmailExists(String email) {
    String query = "SELECT COUNT(*) FROM users WHERE u_email = ?"; 
    try (PreparedStatement pst = connect.prepareStatement(query)) {
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            return true;
        }
    } catch (SQLException ex) {
        System.err.println("Error checking email existence: " + ex.getMessage());
    }
    return false;
}
 public void closeConnection() {
        if (connect != null) {
            try {
                connect.close();
                System.out.println("Database connection closed.");
            } catch (SQLException ex) {
                System.err.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
}


