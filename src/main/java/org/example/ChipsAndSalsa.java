package org.example;

public class ChipsAndSalsa implements Billable{
    @Override
    public double getPrice() {
        return 1.50;
    }
    @Override
    public String toString() {
        return "Chips & Salsa - $1.50";
    }
}
