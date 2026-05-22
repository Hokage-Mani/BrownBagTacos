package org.example;

public record Topping(String name, boolean isPremium, double extraCost) {}
//    private String name;
//    private boolean isPremium;
//    private double extraCost;
//
//    public Topping(String name, boolean isPremium, double extraCost) {
//        this.name = name;
//        this.isPremium = isPremium;
//        this.extraCost = extraCost;
//    }
//    public String getName() {
//        return name;
//    }
//    public boolean isPremium() {
//        return isPremium;
//    }
//    public double getExtraCost() {
//        return extraCost;
//    }
//    @Override
//    public String toString() {
//        return name + (isPremium ? " (Premium)" : "");
//    }

