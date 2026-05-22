package org.example;

import java.util.ArrayList;
import java.util.List;

public class Taco {
private TacoSize size;
private ShellType shell;
private String listToppings;
private List<Topping> toppings;
    private boolean hasSalsa;
    private boolean hasQueso;

    public Taco(TacoSize size, ShellType shell) {
        this.size = size;
        this.shell = shell;
        this.toppings = new ArrayList<>();
        this.hasSalsa = false;
        this.hasQueso = false;
    }
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }
    public void setHasSalsaCovering(boolean hasSalsaCovering) {
        this.hasSalsa = hasSalsaCovering;
    }
    public void setHasQuesoCovering(boolean hasQuesoCovering) {
        this.hasQueso = hasQuesoCovering;
    }
    public double calculatePrice() {
        double total = size.getBasePrice();
        for (Topping item : toppings) {
            total += item.getExtraCost();
        }
        return total;
    }
}
