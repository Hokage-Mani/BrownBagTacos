package org.example;
import java.util.List;

import java.time.LocalDateTime;

public class Order {
    private String customerName;
    private PaymentType paymentMethod;
    private LocalDateTime orderTime;
    private List<Billable> cartItems;
}
