package com.mycompany;

import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }

        double subtotal = 0;
        List<Shippable> shippingItems = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product.isExpired()) {
                System.out.println("Error: " + product.getName() + " is expired");
                return;
            }

            if (product.getQuantity() < quantity) {
                System.out.println("Error: " + product.getName() + " is out of stock");
                return;
            }

            subtotal += product.getPrice() * quantity;

            if (product.isShipping() && product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    shippingItems.add((Shippable) product);
                }
            }
        }

        double shippingFee = shippingItems.isEmpty() ? 0 : 30;
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance");
            return;
        }

        if (!shippingItems.isEmpty()) {
            ShippingService.shipItems(shippingItems);
        }

        customer.deduct(total);

        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            int qty = entry.getValue();
            Product p = entry.getKey();
            System.out.println(qty + "x " + p.getName() + " " + (int)(qty * p.getPrice()));
        }

        System.out.println("----------------------");
        System.out.println("Subtotal " + (int)subtotal);
        System.out.println("Shipping " + (int)shippingFee);
        System.out.println("Amount " + (int)total);
        System.out.println("END.");
    }
}
