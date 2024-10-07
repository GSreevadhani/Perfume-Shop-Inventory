package com.login;

import java.sql.*;
import java.util.Scanner;

public class Inventory {
    Statement stmt;
    ResultSet rs;
    Connection con;

    DBUtil db = new DBUtil();
    Scanner sc = new Scanner(System.in);

    // Add a new product
    void add(PerfumeShop p) {
        try {
            con = db.getDBConnection();
            String qry = "INSERT INTO perfumeshop(prod_id, name, essence, price) VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(qry);
            pstmt.setString(1, p.getProd_id());
            pstmt.setString(2, p.getName());
            pstmt.setString(3, p.getEssence());
            pstmt.setDouble(4, p.getPrice());
            int count = pstmt.executeUpdate();
            if (count == 1) {
                System.out.println("Product added successfully.");
            } else {
                System.out.println("Failed to add product.");
            }
            pstmt.close();
        } catch (Exception ex) {
            System.out.println("Add Product Error: " + ex.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Connection Closing Error: " + e.getMessage());
            }
        }
    }

    // Display all products
    void show() {
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM perfumeshop");
            while (rs.next()) {
                PerfumeShop p = new PerfumeShop();
                p.setProd_id(rs.getString("prod_id"));
                p.setName(rs.getString("name"));
                p.setEssence(rs.getString("essence"));
                p.setPrice(rs.getDouble("price"));
                System.out.println(p); 
            }
        } catch (Exception ex) {
            System.out.println("Show Products Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Resource Closing Error: " + e.getMessage());
            }
        }
    }

    // Remove a product by ID
    void remove(String prodId) {
        try {
        	con = db.getDBConnection();
            String deleteCartSQL = "DELETE FROM cart WHERE prod_id = ?";
            PreparedStatement deleteCartStmt = con.prepareStatement(deleteCartSQL);
            deleteCartStmt.setString(1, prodId);
            deleteCartStmt.executeUpdate();

            // Now delete from perfumeshop
            String deleteProductSQL = "DELETE FROM perfumeshop WHERE prod_id = ?";
            PreparedStatement deleteProductStmt = con.prepareStatement(deleteProductSQL);
            deleteProductStmt.setString(1, prodId);
            deleteProductStmt.executeUpdate();

            System.out.println("Product removed successfully.");
        } catch (SQLException e) {
            System.out.println("Remove Product Error: " + e.getMessage());
        }
    }


    // Sort products by price
    public void sortByPrice() {
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM perfumeshop ORDER BY price ASC");
            System.out.println("ID\tName\tEssence\tPrice");
            while (rs.next()) {
                PerfumeShop p = new PerfumeShop();
                p.setProd_id(rs.getString("prod_id"));
                p.setName(rs.getString("name"));
                p.setEssence(rs.getString("essence"));
                p.setPrice(rs.getDouble("price"));
                System.out.println(p);  // uses toString() method
            }
        } catch (Exception ex) {
            System.out.println("Sort By Price Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Resource Closing Error: " + e.getMessage());
            }
        }
    }

    // Sort products by name
    public void sortByName() {
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM perfumeshop ORDER BY name ASC");
            System.out.println("ID\tName\tEssence\tPrice");
            while (rs.next()) {
                PerfumeShop p = new PerfumeShop();
                p.setProd_id(rs.getString("prod_id"));
                p.setName(rs.getString("name"));
                p.setEssence(rs.getString("essence"));
                p.setPrice(rs.getDouble("price"));
                System.out.println(p);  // uses toString() method
            }
        } catch (Exception ex) {
            System.out.println("Sort By Name Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Resource Closing Error: " + e.getMessage());
            }
        }
    }
    
    public void update(String prod_id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = db.getDBConnection();
            String selectQuery = "SELECT * FROM perfumeshop WHERE prod_id = ?";
            pstmt = con.prepareStatement(selectQuery);
            pstmt.setString(1, prod_id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Update Options: 1. Name  2. ID  3. Price  4. Essence");
                System.out.print("Choose an option to update: ");
                int op = Integer.parseInt(sc.nextLine());

                String updateQuery = "";
                pstmt = null;

                switch (op) {
                    case 1:
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        updateQuery = "UPDATE perfumeshop SET name = ? WHERE prod_id = ?";
                        pstmt = con.prepareStatement(updateQuery);
                        pstmt.setString(1, newName);
                        pstmt.setString(2, prod_id);
                        break;

                    case 2:
                        System.out.print("Enter new ID: ");
                        String newId = sc.nextLine();
                        updateQuery = "UPDATE perfumeshop SET prod_id = ? WHERE prod_id = ?";
                        pstmt = con.prepareStatement(updateQuery);
                        pstmt.setString(1, newId);
                        pstmt.setString(2, prod_id);
                        break;

                    case 3:
                        System.out.print("Enter new price: ");
                        double newPrice = Double.parseDouble(sc.nextLine());
                        updateQuery = "UPDATE perfumeshop SET price = ? WHERE prod_id = ?";
                        pstmt = con.prepareStatement(updateQuery);
                        pstmt.setDouble(1, newPrice);
                        pstmt.setString(2, prod_id);
                        break;

                    case 4:
                        System.out.print("Enter new essence: ");
                        String newEssence = sc.nextLine();
                        updateQuery = "UPDATE perfumeshop SET essence = ? WHERE prod_id = ?";
                        pstmt = con.prepareStatement(updateQuery);
                        pstmt.setString(1, newEssence);
                        pstmt.setString(2, prod_id);
                        break;

                    default:
                        System.out.println("Invalid option selected.");
                        return;
                }

                int count = pstmt.executeUpdate();
                if (count > 0) {
                    System.out.println("Product updated successfully.");
                } else {
                    System.out.println("Failed to update the product.");
                }
            } else {
                System.out.println("Product not found.");
            }
        } catch (Exception ex) {
            System.out.println("Update Error: " + ex.getMessage());
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(Exception e){
                System.out.println("Resource Closing Error: " + e.getMessage());
            }
        }
    }

    // Get product by ID
    public PerfumeShop getProductById(String prod_id) {
        PerfumeShop p = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = db.getDBConnection();
            String query = "SELECT * FROM perfumeshop WHERE prod_id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, prod_id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                p = new PerfumeShop();
                p.setProd_id(rs.getString("prod_id"));
                p.setName(rs.getString("name"));
                p.setEssence(rs.getString("essence"));
                p.setPrice(rs.getDouble("price"));
            }
        } catch (Exception ex) {
            System.out.println("Get Product By ID Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Resource Closing Error: " + e.getMessage());
            }
        }
        return p;
    }
}
