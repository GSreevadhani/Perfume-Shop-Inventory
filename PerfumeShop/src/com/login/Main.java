package com.login;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        DBUtil db = new DBUtil();
        String option;

        while (true) {
            System.out.println("***Welcome to the Perfume Shop***");
            System.out.println("1. Admin 2. User 3. Exit");
            System.out.print("Enter your choice: ");
            String roleChoice = sc.nextLine();

            if (roleChoice.equals("1")) {
                // Admin actions
                System.out.print("Username: ");
                String username = sc.nextLine();
                System.out.print("Password: ");
                String password = sc.nextLine();

                boolean isAuthenticated = db.authenticateAdmin(username, password);
                if (isAuthenticated) {
                    System.out.println("\nLogin successful! Welcome Admin");

                    do {
                        System.out.println("1. Add Product");
                        System.out.println("2. Display Products");
                        System.out.println("3. Search Product");
                        System.out.println("4. Remove Product");
                        System.out.println("5. Update Product");
                        System.out.println("6. Sort Products by Price");
                        System.out.println("7. Logout");
                        System.out.print("Choose an option: ");
                        option = sc.nextLine();

                        switch (option) {
                            case "1":
                                PerfumeShop p = new PerfumeShop();
                                System.out.print("Enter Product ID: ");
                                p.setProd_id(sc.nextLine());
                                System.out.print("Enter Product Name: ");
                                p.setName(sc.nextLine());
                                System.out.print("Enter Essence: ");
                                p.setEssence(sc.nextLine());
                                System.out.print("Enter Price: ");
                                p.setPrice(Double.parseDouble(sc.nextLine()));
                                inv.add(p);
                                break;

                            case "2":
                                inv.show();
                                break;

                            case "3":
                                System.out.print("Enter Product ID: ");
                                String prod_id = sc.nextLine();
                                PerfumeShop searchedProduct = inv.getProductById(prod_id);
                                if (searchedProduct != null) {
                                    System.out.println(searchedProduct);
                                } else {
                                    System.out.println("Product not found.");
                                }
                                break;

                            case "4":
                                System.out.print("Enter Product ID to Remove: ");
                                inv.remove(sc.nextLine());
                                break;

                            case "5":
                                System.out.print("Enter Product ID to Update: ");
                                inv.update(sc.nextLine());
                                break;

                            case "6":
                                inv.sortByPrice();
                                break;

                            case "7":
                                System.out.println("Admin logged out.");
                                break;

                            default:
                                System.out.println("Invalid option. Try again.");
                                break;
                        }
                    } while (!option.equals("7"));

                } else {
                    System.out.println("Invalid Admin credentials.");
                }

            } else if (roleChoice.equals("2")) {
                // User actions
                do {
                    System.out.println("1. View Products");
                    System.out.println("2. Add Product to Cart");
                    System.out.println("3. View Cart");
                    System.out.println("4. Checkout and Total Price");
                    System.out.println("5. Logout");
                    System.out.print("Choose an option: ");
                    option = sc.nextLine();

                    switch (option) {
                        case "1":
                            inv.show();
                            break;

                        case "2":
                            System.out.print("Enter Product ID to Add to Cart: ");
                            String prodId = sc.nextLine();
                            PerfumeShop product = inv.getProductById(prodId);
                            if (product != null) {
                                cart.addToCart(product);
                                System.out.println("Product added to cart.");
                            } else {
                                System.out.println("Product not found.");
                            }
                            break;

                        case "3":
                            cart.viewCart();
                            break;

                        case "4":
                            cart.checkout();
                            break;

                        case "5":
                            System.out.println("User logged out.");
                            break;

                        default:
                            System.out.println("Invalid option. Try again.");
                            break;
                    }
                } while (!option.equals("5"));

            } else if (roleChoice.equals("3")) {
                System.out.println("Exiting!!");
                break;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}
