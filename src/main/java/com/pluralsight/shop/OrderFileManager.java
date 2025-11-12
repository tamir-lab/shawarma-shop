package com.pluralsight.shop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class OrderFileManager {
    public void saveOrder(Order order) {
        String storeName = "DELICIOUS";
        String address = "Main street";
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String number = "123";


        String fileName = "receipts/" + date + ".txt";
        String receipt = String.format("""
                ==========================================
                            %s
                          %s
                ------------------------------------------
                Order Date: %s   Time: %s
                Receipt #: %s
                ------------------------------------------
                
                %s
                
                
                Thank you for choosing %s!
                Your taste is as refined as your sandwich.
                ==========================================
                """,
                storeName, address,
                LocalDate.now(), LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                number,
                order.toString(),
                storeName

        );
        try {
            new File("receipts").mkdirs();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                bw.write(receipt);
                bw.flush();
                System.out.println("Order saved: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Failed to save order: " + e.getMessage());
        }
    }
}
