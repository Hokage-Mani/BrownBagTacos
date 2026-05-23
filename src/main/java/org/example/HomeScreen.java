package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Cart cart = new Cart();

        boolean isOrdering = true;

        System.out.println("Welcome to the Brown Bag Tacos POS!");


        while (isOrdering) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Order a Signature Taco");
            System.out.println("2. Build a Custom Taco");
            System.out.println("3. Add Chips & Salsa ($1.50)");
            System.out.println("4. View Current Cart");
            System.out.println("5. Checkout");
            System.out.print("Select an option: ");


            String choice = scanner.nextLine();


            switch (choice) {
                case "1":

                    System.out.println("Opening Signature Menu...");
                    break;

                case "2":
                    System.out.println("Opening Custom Taco Builder...");
                    break;

                case "3":

                    cart.addToCart(new ChipsAndSalsa());
                    System.out.println("Added Chips & Salsa to the order!");
                    break;

                case "4":
                    cart.displayCart();
                    break;

                case "5":
                    if (cart.getItems().isEmpty()) {
                        System.out.println("Your cart is empty! Please add items before checking out.");
                        break;
                    }
                    System.out.println("\n=== CHECKOUT ===");
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter Payment Method (Cash, Credit, Debit): ");
                    String paymentInput = scanner.nextLine().toUpperCase();
                    PaymentType paymentMethod = PaymentType.valueOf(paymentInput);
                    Order finalOrder = new Order(customerName, paymentMethod, new ArrayList<>(cart.getItems()));

                    if (!finalOrder.isValidOrder()) {
                        System.out.println("\n[ERROR] Invalid Order!");
                        System.out.println("If you order 0 tacos, you MUST purchase chips & salsa or a drink.");
                        System.out.println("Returning to main menu...");
                        break;
                    }


                    System.out.println("\n--- PLEASE REVIEW YOUR ORDER ---");
                    System.out.println(finalOrder.generateReceipt());


                    System.out.print("Type 'C' to Confirm or 'X' to Cancel: ");
                    String confirmChoice = scanner.nextLine().toUpperCase();

                    if (confirmChoice.equals("C")) {
                        FileManager.saveReceipt(finalOrder);
                        System.out.println("Thank you, " + customerName + "! Your order is complete.");
                        cart.getItems().clear();
                    } else {
                        System.out.println("Order cancelled. Emptying cart...");
                        cart.getItems().clear();
                    }
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }

        scanner.close();
    }
    private static void printWelcomeHeader() {
        System.out.println("       .------------------.       ");
        System.out.println("      /                    \\      ");
        System.out.println("     /                      \\     ");
        System.out.println("    /       BROWN BAG        \\    ");
        System.out.println("   |          TACOS           |   ");
        System.out.println("    \\                        /    ");
        System.out.println("     `----------------------`     ");
        System.out.println("====================================");
    }
}