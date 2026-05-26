package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printWelcomeHeader();
        Menu menu = new Menu();
        Cart cart = new Cart();

        boolean isOrdering = true;

        System.out.println("Welcome to the Brown Bag Tacos POS!");


        while (isOrdering) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Order a Signature Taco");
            System.out.println("2. Open Order Screen");
            System.out.println("3. Add Chips & Salsa ($1.50)");
            System.out.println("4. View Current Cart");
            System.out.println("5. Checkout");
            System.out.println("99) Exit Application!");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    List<SignatureTaco> sigs = menu.getSignatureMenu();
                    System.out.println("\n--- SIGNATURE MENU ---");
                    for (int i = 0; i < sigs.size(); i++) {
                        System.out.println((i + 1) + ") " + sigs.get(i).getname());
                    }
                    System.out.println("Enter signature taco you would you like to add: ");
                    String tacoChoice = scanner.nextLine();
                    int index;
                    try {
                        index = Integer.parseInt(tacoChoice) - 1;
                        if (index < 0 || index >= sigs.size()) {
                            System.out.println("Invalid Choice");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter valid menu number(1 -3)");
                        break;
                    }
                    SignatureTaco selected = sigs.get(index);
                    SignatureTaco tacoForCart = new SignatureTaco(selected.getname(), selected.getSize(), selected.getShell());
                    for (Topping t : selected.getToppings()) {
                        tacoForCart.addTopping(t);
                    }
                    tacoForCart.setHasSalsa(selected.isHasSalsa());
                    tacoForCart.setHasQueso(selected.isHasQueso());
                    cart.addToCart(tacoForCart);
                    System.out.println(tacoForCart.getname() + " added to cart!");
                    break;

                case "2":
                    boolean inOrderMenu = true;
                    while (inOrderMenu) {
                        System.out.println("Starting Order...");
                        System.out.println("A) Add Taco");
                        System.out.println("D Add Drink");
                        System.out.println("C) Confirm selections & Home to checkout");
                        System.out.println("X) Cancel selections & return Home");

                        String orderChoice = scanner.nextLine().trim().toUpperCase();
                        switch (orderChoice) {
                            case "A":
                                System.out.println("\n === Taco Builder ===");
                                System.out.println("Selecting taco serving size: ");
                                int i = 1;
                                for (TacoSize size : TacoSize.values()) {
                                    System.out.printf("%d) %s ($%.2f)\n", i, size, size.getBasePrice());
                                    i++;
                                }
                                TacoSize selectedSize = null;
                                while (selectedSize == null) {
                                    System.out.print("Enter choice: ");
                                    try {
                                        int sizeChoice = Integer.parseInt(scanner.nextLine());
                                        if (sizeChoice >= 1 && sizeChoice <= TacoSize.values().length) {
                                            selectedSize = TacoSize.values()[sizeChoice - 1];
                                        } else {
                                            System.out.println("[ERROR] Please select a valid number from the menu.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("[ERROR] Invalid input. Please type a number.");
                                    }
                                }
                                System.out.println("\nSelecting Shell: ");
                                i = 1;
                                for (ShellType shell : ShellType.values()) {
                                    System.out.println(i + ") " + shell);
                                    i++;
                                }
                                ShellType selectedShell = null;
                                while (selectedShell == null) {
                                    System.out.print("Enter choice: ");
                                    try {
                                        int shellChoice = Integer.parseInt(scanner.nextLine());
                                        if (shellChoice >= 1 && shellChoice <= ShellType.values().length) {
                                            selectedShell = ShellType.values()[shellChoice - 1];
                                        } else {
                                            System.out.println("[ERROR] Please select a valid number from the menu.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("[ERROR] Invalid input. Please type a number.");
                                    }
                                }
                                CustomTaco taco = new CustomTaco(selectedSize, selectedShell);
                                boolean toppingOptions = true;
                                while (toppingOptions) {
                                    System.out.println("\n--- Add Toppings ---");
                                    System.out.println("1) Regular Toppings");
                                    System.out.println("2) Premium Toppings");
                                    System.out.println("X) Next ->");

                                    String toppingMenuChoice = scanner.nextLine().trim().toUpperCase();

                                    switch (toppingMenuChoice) {
                                        case "1":
                                            pickTopping(menu.getRegularToppings(), taco, scanner);
                                            break;
                                        case "2":
                                            pickTopping(menu.getPremiumToppings(), taco, scanner);
                                            break;
                                        case "X":
                                            toppingOptions = false;
                                            break;
                                        default:
                                            System.out.println("[ERROR] Invalid choice. Please enter 1, 2, or X.");
                                    }
                                }
                                System.out.println("\n--- Final Touches ---");
                                boolean validCovering = false;

                                while (!validCovering) {
                                    System.out.print("Add a covering? (S = Salsa, Q = Queso, B = Both, N = None): ");
                                    String coveringChoice = scanner.nextLine().trim().toUpperCase();
                                    switch (coveringChoice) {
                                        case "B":
                                            taco.setHasSalsa(true);
                                            taco.setHasQueso(true);
                                            System.out.println("Covered in Salsa and Queso!");
                                            validCovering = true;
                                            break;
                                        case "S":
                                            taco.setHasSalsa(true);
                                            System.out.println("Covered in Salsa!");
                                            validCovering = true;
                                            break;
                                        case "Q":
                                            taco.setHasQueso(true);
                                            System.out.println("Covered in Queso!");
                                            validCovering = true;
                                            break;
                                        case "N":
                                            System.out.println("No coverings added.");
                                            validCovering = true;
                                            break;
                                        default:
                                            System.out.println("[ERROR] Invalid input. Please type S, Q, B, or N.");
                                            break;
                                    }
                                }
                                cart.addToCart(taco);
                                System.out.println("\nTaco added to your cart!");
                                break;
                            case "D":
                                System.out.println("Selecting Drink(S)...");
                                int d = 1;
                                for (DrinkSize size : DrinkSize.values()) {
                                    System.out.printf("%d) %s ($%.2f)\n", d, size, size.getPrice());
                                    d++;
                                }
                                System.out.println("Enter choice: ");
                                int drinkChoice = Integer.parseInt(scanner.nextLine());
                                DrinkSize selectedDrink = DrinkSize.values()[drinkChoice - 1];
                                System.out.println("Flavors: Lemonade, Iced Tea, Dr.Pepper, Water, " +
                                        "Sprite, Orange Juice");
                                System.out.println("Select drink flavor: ");
                                String selectedFlavor = scanner.nextLine().trim();
                                Drinks drink = new Drinks(selectedDrink, selectedFlavor);
                                cart.addToCart(drink);
                                System.out.println("Added " + selectedDrink + " " + selectedFlavor +
                                        "to your cart!");
                                break;
                            case "C":
                                System.out.println("Returning to Home Screen...");
                                inOrderMenu = false;
                                break;
                            case "X":
                                System.out.println("Cancelling selections and returning Home...");
                                cart.getItems().clear();
                                inOrderMenu = false;
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    }
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
                    finalOrder.setOrderTime(java.time.LocalDateTime.now());
                    if (!finalOrder.isValidOrder()) {
                        System.out.println("\n[ERROR] Invalid Order!");
                        System.out.println("You have 0 tacos, you MUST purchase chips & salsa or a drink.");
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
                case "99":
                    System.out.println("\nThank you for eating with us. Come again!\n");
                    isOrdering = false;
                    //TODO double check if this is properly cased so that it doesn't ruin the boolean.
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

    private static void pickTopping(List<Topping> list, Taco taco, Scanner scanner) {
        System.out.println("\nSelect a topping:");
        for (int i = 0; i < list.size(); i++) {
            Topping t = list.get(i);
            System.out.printf("%d) %s%s\n", i + 1, t.name(), t.isPremium() ? " (+$" + t.extraCost() + ")" : "");
        }
        System.out.println((list.size() + 1) + ") Go Back");
        boolean validSelection = false;
        while (!validSelection) {
            System.out.print("Choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == list.size() + 1) {
                    validSelection = true;
                } else if (choice >= 1 && choice <= list.size()) {
                    taco.addTopping(list.get(choice - 1));
                    System.out.println(list.get(choice - 1).name() + " added!");
                    validSelection = true;
                } else {
                    System.out.println("[ERROR] Please select a valid number from the list.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Invalid input. Please type a number.");
            }
        }
    }
}