package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<Taco> cart = new ArrayList<>();

    public void addToCart(Taco product){
        cart.add(product);
    }

    public void removeFromCart(Taco product){
        cart.remove(product);
    }

    public double getCartTotal() {
        double total = 0;
        for(Taco p : cart){
            total += p.getPrice();
        }
        return total;
    }
    public void displayCart(){
        if(cart.isEmpty()){
            System.out.println("Cart is currently empty.");
            return;
        }
        for(Taco product : cart){
            System.out.println("SKU: " + product.getSku() + " | " + product.getName() + " | $" + product.getPrice());
        }
    }
}
