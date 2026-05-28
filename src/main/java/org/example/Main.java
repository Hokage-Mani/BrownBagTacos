package org.example;

import javax.swing.*;
import java.awt.Desktop;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        String[] options = {"Run POS System", "Visit Website"};
        int choice = JOptionPane.showOptionDialog(null,
                "Welcome to Brown Bag Tacos!\nWhat would you like to launch?",
                "Brown Bag Tacos Launcher",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
        if (choice == 0) {
            System.out.println("Starting the Terminal POS System...\n");
            HomeScreen.main(args);
        } else if (choice == 1) {
            System.out.println("Launching browser...");
            openWebsite();

        } else {
            System.out.println("Launcher closed.");
        }
    }
    private static void openWebsite() {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://cupcakesam1121.wixsite.com/brownbagtacos"));
            }
        } catch (Exception ex) {
            System.out.println("Oops! Could not open the website.");
        }
    }
}