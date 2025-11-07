package com.pluralsight.shop;

import com.pluralsight.shop.items.Shawarma;
import com.pluralsight.shop.toppings.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("=".repeat(30));
            System.out.println("Welcome to Shawarma Shop!");
            System.out.println("1 - New Order\n" +
                               "0 - Exit");
            String firstInput = scanner.nextLine();
            switch(firstInput) {
                case "1" -> orderScreen(scanner);
                case "0" -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
        System.out.println("Thank you for visiting us!");

        scanner.close();
    }

    public void orderScreen(Scanner scanner) {
        Order order = new Order("awe", LocalDateTime.now().toString());
        boolean running = true;
        while(running){
            System.out.println("=".repeat(30));
            System.out.println("Order options.");
            System.out.println("""
                    1 - Add Sandwich
                    2 - Add Drink
                    3 - Add Chips
                    4 - Checkout
                    0 - Cancel Order""");
            String secondInput = scanner.nextLine();
            switch(secondInput) {
                case "1" -> addShawarma(scanner,order);
                case "2" -> addDrink(scanner);
                case "3" -> addChips(scanner);
                case "4" -> checkout(scanner);
                case "0" -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }



}
