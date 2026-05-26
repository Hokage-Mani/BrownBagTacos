package org.example;
import java.time.format.DateTimeFormatter;
import java.util.List;
import de.vandermeer.asciitable.AsciiTable;
import java.time.LocalDateTime;

public class Order {
    private String customerName;
    private PaymentType paymentMethod;
    private LocalDateTime orderTime;
    private List<Billable> cartItems;


    public Order(String customerName, PaymentType paymentMethod, List<Billable> cartItems) {
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
        this.cartItems = cartItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public PaymentType getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<Billable> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Billable> cartItems) {
        this.cartItems = cartItems;
    }

    //total order price
    public double calculateOrderTotal() {
        double total = 0;
        for (Billable item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }

    //For when customers don't order any tacos :(
    public boolean isValidOrder() {
        int tacoCount = 0;
        int drinkOrSide = 0;

        for (Billable item : cartItems) {
            if (item instanceof Taco) {
                tacoCount++;
            } else if (item instanceof Drinks) {
                drinkOrSide++;
            }
        }
        if (tacoCount == 0 && drinkOrSide == 0) {
            return false;
        }
        return true;
    }

//    public String generateReceipt() {
//        StringBuilder receipt = new StringBuilder();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
//        String formattedTime = orderTime.format(formatter);
//
//        receipt.append("====================================\n");
//        receipt.append("         BROWN BAG TACOS\n"); // Updated name!
//        receipt.append("====================================\n");
//        receipt.append("Customer: ").append(customerName).append("\n");
//        receipt.append("Date: ").append(formattedTime).append("\n");
//
//        return receipt.toString();
//    }
    //TODO testing out built-in depencies here
public String generateReceipt() {
    AsciiTable table = new AsciiTable();
    table.addRule();
    table.addRow("ITEM DESCRIPTION", "PRICE");
    table.addRule();
    for (Billable item : cartItems) {
        String itemName = "Menu Item";
        if (item instanceof SignatureTaco) {
            itemName = ((SignatureTaco) item).getname();
        } else if (item instanceof Taco) {
            itemName = "Custom " + ((Taco) item).getSize() + " Taco";
        } else if (item instanceof ChipsAndSalsa) {
            itemName = "Chips & Salsa";
        } else if (item instanceof Drinks) {
            itemName = ((Drinks) item).getSize() + " " + ((Drinks) item).getFlavor();
        }
        String priceStr = String.format("$%.2f", item.getPrice());
        table.addRow(itemName, priceStr);
        table.addRule();
    }
    table.addRow("GRAND TOTAL", String.format("$%.2f", calculateOrderTotal()));
    table.addRule();
    String header = "\n====================================\n" +
            "          BROWN BAG TACOS\n" +
            "====================================\n" +
            "Customer: " + customerName + "\n" +
            "Payment: " + paymentMethod + "\n\n";

    return header + table.render();
}
}
