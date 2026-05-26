package org.example;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        JFrame frame = new JFrame("Brown Bag Tacos POS");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton checkoutButton = new JButton("Checkout Order");
        checkoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Order sent to FileManager!");
        });

        frame.add(checkoutButton);
        frame.setVisible(true);
    }
}
