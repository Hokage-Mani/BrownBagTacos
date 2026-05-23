package org.example;

import java.util.ArrayList;
import java.util.List;

public class Taco implements Billable{
private TacoSize size;
private ShellType shell;
//private String listToppings;
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
    public double calculatePrice() {
        double total = size.getBasePrice();
        for (Topping item : toppings) {
            total += item.extraCost();
        }
        return total;
    }
    public TacoSize getSize() {
        return size;
    }
    public void setSize(TacoSize size) {
        this.size = size;
    }
    public ShellType getShell() {
        return shell;
    }
    public void setShell(ShellType shell) {
        this.shell = shell;
    }
    public List<Topping> getToppings() {
        return toppings;
    }
    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
    public boolean isHasSalsa() {
        return hasSalsa;
    }
    public void setHasSalsa(boolean hasSalsa) {
        this.hasSalsa = hasSalsa;
    }
    public boolean isHasQueso() {
        return hasQueso;
    }
    public void setHasQueso(boolean hasQueso) {
        this.hasQueso = hasQueso;
    }
    //connects to Billable class
    @Override
    public double getPrice() {
        return calculatePrice();
    }
    //format for the receipt
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append(" on a ").append(shell).append(" shell\n");

        if (!toppings.isEmpty()) {
            sb.append("  Toppings: ");
            for (Topping t : toppings) {
                sb.append(t.name()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }
        if (hasSalsa) sb.append("  - Covered in Salsa\n");
        if (hasQueso) sb.append("  - Covered in Queso\n");
        sb.append(String.format("  Price: $%.2f", getPrice()));
        return sb.toString();
    }
}
