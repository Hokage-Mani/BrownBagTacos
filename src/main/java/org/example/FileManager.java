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
}