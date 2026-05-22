package org.example;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
// 1. Create the pop-out window (JFrame)
        JFrame frame = new JFrame("TACO-li-cious POS");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Create a clickable button
        JButton checkoutButton = new JButton("Checkout Order");

        // 3. Tell the button what to do when clicked
        checkoutButton.addActionListener(e -> {
            // This pops up a smaller alert box when clicked!
            JOptionPane.showMessageDialog(frame, "Order sent to FileManager!");
        });

        // 4. Add the button to the window and show it
        frame.add(checkoutButton);
        frame.setVisible(true);
    }
}
