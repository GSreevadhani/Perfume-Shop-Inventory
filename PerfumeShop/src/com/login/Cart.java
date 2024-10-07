package com.login;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<PerfumeShop> cartItems = new ArrayList<>();

    // Add 
    public void addToCart(PerfumeShop p) {
        cartItems.add(p);
    }

    // View
    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (PerfumeShop p : cartItems) {
                System.out.println(p);
            }
        }
    }

    // Checkout
    public void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            double total = 0;
            for (PerfumeShop p : cartItems) {
                System.out.println(p);
                total += p.getPrice();
            }
            System.out.println("Total Price: " + total);
        }
    }
}
