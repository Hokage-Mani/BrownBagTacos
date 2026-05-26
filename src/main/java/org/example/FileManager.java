package org.example;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void saveReceipt(Order finalOrder) {
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir();
        }
        DateTimeFormatter fileFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timeStamp = finalOrder.getOrderTime().format(fileFormat);
        String fileName = "receipts/Receipt_" + timeStamp + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(finalOrder.generateReceipt());
            System.out.println("Success! Receipt saved! " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
    public static void displayReceipts() {
        java.io.File folder = new java.io.File("receipts");
        java.io.File[] listOfFiles = folder.listFiles();
        if (!folder.exists() || listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("No receipts found. You haven't made any sales yet!");
            return;
        }
        System.out.println("Found " + listOfFiles.length + " receipt(s). Printing history...\n");
        for (java.io.File file : listOfFiles) {
            System.out.println(">>>> Reading: " + file.getName());

            try (java.util.Scanner fileScanner = new java.util.Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
            } catch (java.io.FileNotFoundException e) {
                System.out.println("[ERROR] Could not read " + file.getName());
            }
            System.out.println("\n");
        }
    }
}