package com.mycompany;

import java.util.*;

public class Cart {
    private Map<Product, Integer> products = new LinkedHashMap<>();

    public void add(Product product, int qty) {
        if (qty > product.getQuantity()) {
            System.out.println("Error: Requested quantity exceeds available stock for " + product.getName());
            return;
        }
        products.put(product, products.getOrDefault(product, 0) + qty);
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
