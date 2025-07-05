package com.mycompany;

public class TV extends Product implements Shippable {
    private double weight;

    public TV(int price, int quantity, String name, double weight) {
        super(price, quantity, name);
        this.weight = weight;
    }

    public boolean isExpired() {
        return false;
    }

    public boolean isShipping() {
        return true;
    }

    public double getWeight() {
        return weight;
    }
}
