package com.mycompany;

public class MobileScratchCard extends Product {
    public MobileScratchCard(int price, int quantity, String name) {
        super(price, quantity, name);
    }

    public boolean isExpired() {
        return false;
    }

    public boolean isShipping() {
        return false;
    }
}
