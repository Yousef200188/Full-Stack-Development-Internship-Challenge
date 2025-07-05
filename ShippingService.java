package com.mycompany;

import java.util.*;

public class ShippingService {
    public static void shipItems(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        Map<String, Integer> counts = new LinkedHashMap<>();
        Map<String, Double> weights = new HashMap<>();
        

        for (Shippable item : items) {
            String name = item.getName();
            counts.put(name, counts.getOrDefault(name, 0) + 1);
            weights.put(name, item.getWeight()); 
        }
        double totalWeight = 0;
        for (String name : counts.keySet()) {
            int count = counts.get(name);
            double weightPerItem = weights.get(name);
            double weightForProduct = count * weightPerItem;
            totalWeight += weightForProduct;

            System.out.println(count + "x " + name + " " + (int)(weightForProduct * 1000) + "g");
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}
