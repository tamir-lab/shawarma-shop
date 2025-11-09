package com.pluralsight.shop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class OrderFileManager {
    public void saveOrder(Order order) {
        String fileName = LocalDate.now() + "-" + LocalTime.now() + ".txt";
        /*String receipt = String.format("""
                ==========================================
                            %s
                          %s
                ------------------------------------------
                Order Date: %s   Time: %s
                Receipt #: %s
                ------------------------------------------



                Thank you for choosing %s!
                Your taste is as refined as your sandwich.
                ==========================================
                """,

        );*/
        /*try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)) ) {
            bw.write(
                    order.toString());
            bw.newLine();
            ArrayList<Vehicle> inventory = dealership.getAllVehicles();

            for (Vehicle vehicle : inventory) {
                bw.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                bw.newLine();
            }
            System.out.println("Dealership saved.");
        } catch (Exception e) {
            throw new RuntimeException(e);*/
        }
}
