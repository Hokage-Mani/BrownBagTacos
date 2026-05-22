package org.example;

public enum TacoSize {
    SINGLE_TACO(3.50),
    PLATE_OF_3(9.00),
    BURRITO(8.00);

    TacoSize(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice(){
        return basePrice;
    }
}
