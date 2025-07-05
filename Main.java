package com.mycompany;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date tomorrow = new Date(System.currentTimeMillis() + 86400000L);

        Product cheese = new Cheese(100, 10, "Cheese", tomorrow, 0.2);
        Product biscuits = new Biscuits(150, 5, "Biscuits", tomorrow, 0.7);

        Customer customer = new Customer("Yousef", 1000);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);

        CheckoutService.checkout(customer, cart);
    }
}
