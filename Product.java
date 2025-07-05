package com.mycompany;

public abstract class Product {
    protected int price;
    protected int quantity;
    protected String name;

    public Product(int price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void reduceQuantity(int amount) { quantity -= amount; }

    public abstract boolean isExpired();
    public abstract boolean isShipping();
}
