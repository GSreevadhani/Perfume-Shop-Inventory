package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
    public Connection getDBConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeshop", "root", "");
        } catch(Exception ex){
            System.out.println("Database Connection Error: " + ex.getMessage());
        }
        return con;
    }

    public boolean authenticateAdmin(String username, String password){
        boolean isAuthenticated = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = getDBConnection();
            String query = "SELECT * FROM admins WHERE username = ? AND password = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()){
                isAuthenticated = true;
            }
        } catch(Exception ex){
            System.out.println("Authentication Error: " + ex.getMessage());
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(Exception e){
                System.out.println("Resource Closing Error: " + e.getMessage());
            }
        }
        return isAuthenticated;
    }
}
