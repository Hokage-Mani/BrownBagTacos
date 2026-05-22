package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Billable> items = new ArrayList<>();

    public void addToCart(Billable item){
        items.add(item);
    }
    public void removeFromCart(Billable item){
        items.remove(item);
    }
    public double getCartTotal() {
        double total = 0;
        for(Billable item : items){
            total += item.getPrice();
        }
        return total;
    }
    public void displayCart(){
        if(items.isEmpty()){
            System.out.println("Cart is currently empty.");
            return;
        }
        System.out.println("--- CURRENT ORDER ---");
        for(Billable item : items){
            System.out.println(item.toString());
            System.out.println("---------------------");
        }
        System.out.printf("ORDER TOTAL: $%.2f\n", getCartTotal());
    }

    public List<Billable> getItems() {
        return items;
    }
}