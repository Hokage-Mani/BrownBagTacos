package org.example;

public class Drinks implements Billable{
    private DrinkSize size;
    private String flavor;

    public DrinkSize getSize() {
        return size;
    }
    public void setSize(DrinkSize size) {
        this.size = size;
    }
    public String getFlavor() {
        return flavor;
    }
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    public Drinks(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }
    @Override
    public double getPrice() {
        return size.getPrice();
    }
    //Format for the receipt
    @Override
    public String toString() {
        // Output example: "LARGE Coke - $2.50"
        return size + " " + flavor + " - $" + String.format("%.2f", getPrice());
    }
}
