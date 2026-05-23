package org.example;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Topping> regularToppings;
    private List<Topping> premiumToppings;
    private List<SignatureTaco> signatureMenu;

    public Menu() {
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
        this.signatureMenu = new ArrayList<>();

        loadToppings();
        loadSignatureTacos();
    }
    private void loadToppings() {
        regularToppings.add(new Topping("Shredded Chicken", false, 0.00));
        regularToppings.add(new Topping("Grilled Chicken", false, 0.00));
        regularToppings.add(new Topping("Ground Beef", false, 0.00));
        regularToppings.add(new Topping("Grilled Veggies", false, 0.00));
        regularToppings.add(new Topping("Shrimp", false, 0.00));

        // Classic Toppings (Included)
        regularToppings.add(new Topping("Lettuce", false, 0.00));
        regularToppings.add(new Topping("Cilantro", false, 0.00));
        regularToppings.add(new Topping("Onions", false, 0.00));
        regularToppings.add(new Topping("Tomatoes", false, 0.00));
        regularToppings.add(new Topping("Jalapenos", false, 0.00));
        regularToppings.add(new Topping("Pico de Gallo", false, 0.00));
        regularToppings.add(new Topping("Guac", false, 0.00));

        // Sauces & Extras (Included)
        regularToppings.add(new Topping("Chipotle Aioli", false, 0.00));
        regularToppings.add(new Topping("Salsa Verde", false, 0.00));
        regularToppings.add(new Topping("Habanero", false, 0.00));
        regularToppings.add(new Topping("Salsa Roja", false, 0.00));
        regularToppings.add(new Topping("Lime Wedges", false, 0.00));
        regularToppings.add(new Topping("Crema", false, 0.00));

        // Premium Toppings ($1.95 extra)
        premiumToppings.add(new Topping("Steak", true, 1.95));
        premiumToppings.add(new Topping("Barbacoa", true, 1.95));
        premiumToppings.add(new Topping("Lamb", true, 1.95));
    }

    private void loadSignatureTacos() {
        //Brown Bag Classic
        SignatureTaco classic = new SignatureTaco("Brown Bag Classic (15 Tacos)", TacoSize.PARTY_PACK,
                ShellType.HARD_SHELL);
        classic.addTopping(new Topping("Braised Beef", true, 0.00));
        classic.addTopping(new Topping("Onions", false, 0.00));
        classic.addTopping(new Topping("Cilantro", false, 0.00));
        classic.addTopping(new Topping("White Rice", false, 0.00));
        classic.addTopping(new Topping("Whole Pinto Beans", false, 0.00));
        signatureMenu.add(classic);

        //Every Meat Burrito
        SignatureTaco meatBurrito = new SignatureTaco("Every Meat Burrito", TacoSize.BURRITO, ShellType.FLOUR);
        meatBurrito.addTopping(new Topping("Lamb, Camel, Emu, Bison, Python, Wild Boar",
                true, 10.00));
        meatBurrito.addTopping(new Topping("Rice", false, 0.00));
        meatBurrito.addTopping(new Topping("Salsa Roja", false, 0.00));
        signatureMenu.add(meatBurrito);

        //Gloom Depths Taco (3)
        SignatureTaco gloom = new SignatureTaco("Gloom Depths Taco", TacoSize.PLATE_OF_3, ShellType.CORN);
        gloom.addTopping(new Topping("BBQ Jackfruit", true, 8.99));
        gloom.addTopping(new Topping("Pulled Cabbage", false, 0.00));
        gloom.addTopping(new Topping("Charred Peppers", false, 0.00));
        gloom.addTopping(new Topping("Black Beans", false, 0.00));
        gloom.addTopping(new Topping("Gloom Smoke Sauce", false, 0.00));
        gloom.setHasQueso(true);
        signatureMenu.add(gloom);
    }
    public List<Topping> getRegularToppings() { return regularToppings; }
    public List<Topping> getPremiumToppings() { return premiumToppings; }
    public List<SignatureTaco> getSignatureMenu() { return signatureMenu; }
}