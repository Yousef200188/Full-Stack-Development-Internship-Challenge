package com.mycompany;

import java.util.Date;

public class Cheese extends Product implements Shippable {
    private Date expiryDate;
    private double weight;

    public Cheese(int price, int quantity, String name, Date expiryDate, double weight) {
        super(price, quantity, name);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public boolean isExpired() {
        return new Date().after(expiryDate);
    }

    public boolean isShipping() {
        return true;
    }

    public double getWeight() {
        return weight;
    }
}
