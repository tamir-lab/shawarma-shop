package com.pluralsight.shop;

import com.pluralsight.shop.items.Drink;
import com.pluralsight.shop.items.Fries;
import com.pluralsight.shop.items.Shawarma;
import com.pluralsight.shop.toppings.*;
import com.pluralsight.shop.toppings.protein.Cheese;
import com.pluralsight.shop.toppings.protein.CheeseType;
import com.pluralsight.shop.toppings.protein.Meat;
import com.pluralsight.shop.toppings.protein.MeatType;
import com.pluralsight.shop.toppings.regular.*;


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
                case "2" -> addDrink(scanner,order);
                case "3" -> addFries(scanner,order);
                case "4" -> checkout(scanner,order);
                case "0" -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public void addShawarma(Scanner scanner, Order order) {

        Shawarma shawarma = new Shawarma("","", false);

        shawarma.setBreadType(selectBread(scanner));
        shawarma.setSize(selectShawarmaSize(scanner));
        addAllMeats(scanner,shawarma);
        addCheese(scanner,shawarma);
        otherToppings(scanner,shawarma);
        selectSauces(scanner,shawarma);
        shawarma.setToasted(toast(scanner));

        System.out.println(shawarma);
        order.addShawarma(shawarma);
    }

    private String selectBread(Scanner scanner) {
        System.out.println("""
                Bread selection:
                1 - Pita Bread – the standard choice; soft, slightly chewy, perfect pocket for stuffing.
                2 - Markouk (Saj Bread) – thin, delicate Lebanese flatbread; wraps tight and lets the fillings shine.
                3 - Lavash – slightly thicker and stretchier; holds up better if you overfill your wrap (which you will).
                4 - Tannour Bread – thicker, rustic, with a smoky flavor from the clay oven.\
                What bread would you like?""");
        String breadType = "";
        boolean running = true;
        while(running) {
            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1" -> {
                    breadType = "Pita Bread";
                    System.out.println(breadType);
                    running = false;
                }
                case "2" -> {
                    breadType = "Markouk";
                    System.out.println(breadType);
                    running = false;
                }
                case "3" -> {
                    breadType = "Lavash";
                    System.out.println(breadType);
                    running = false;
                }
                case "4" -> {
                    breadType = "Tannour Bread";
                    System.out.println(breadType);
                    running = false;
                }

                default -> System.out.println("Invalid option. Please enter 1,2,3 or 4.");
            }
        }
        return breadType;

    }

    private String selectShawarmaSize(Scanner scanner) {
        System.out.print("""
                Size Selection
                5 - Small
                8 - Regular
                12 - Large
                Select the size:
                """);
        String size = "";
        boolean running = true;
        while (running) {
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "5" -> {
                    size = "small";
                    running = false;
                }
                case "8" -> {
                    size = "regular";
                    running = false;
                }
                case "12" -> {
                    size = "large";
                    running = false;
                }
                default -> System.out.println("Invalid option. Please enter 5,8 or 12");
            }
        }
        return size;
    }

    public void addAllMeats(Scanner scanner,Shawarma shawarma) {
        addMeat(scanner,shawarma);
        System.out.println("Would you like to add another meat? Y/N");
        String choice;
        boolean running = true;
        while(running) {
            choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("y")) {
                addMeat(scanner,shawarma);
                running = false;
            } else if (choice.equalsIgnoreCase("n")) {
                running = false;
            } else System.out.println("Invalid option. Please Enter Y or N");
        }
    }

    private void addMeat(Scanner scanner, Shawarma shawarma) {

        System.out.println("Side selection:");
        for (MeatType value : MeatType.values()) {
            System.out.println(value.ordinal() + " - " + value.getMeat());
        }
        System.out.println("What side would you like to add? Enter a number");
        String meatChoice = "";
        boolean isExtra;
        boolean running = true;
        while (running) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                for (MeatType value : MeatType.values()) {
                    if (choice == value.ordinal() &&
                            choice != 0){
                        meatChoice = value.getMeat();
                        isExtra = askForExtra(scanner);
                        shawarma.addTopping(new Meat(meatChoice,isExtra));
                        System.out.print(value.ordinal() + " - ");
                        System.out.println(meatChoice + " is added");
                        running = false;
                    }
                }
                if (meatChoice.isEmpty()){
                    if(choice == 0){
                        break;
                    } else {
                        System.out.println("Side is not found.");}
                }
            } catch (Exception e) {
                System.out.println("Enter a number");
            }

        }
    }

    private void addCheese(Scanner scanner, Shawarma shawarma) {

        System.out.println("Side selection:");
        for (CheeseType value : CheeseType.values()) {
            System.out.println(value.ordinal() + " - " + value.getCheese());
        }
        System.out.println("What side would you like to add? Enter a number");
        String cheeseChoice = "";
        boolean running = true;
        boolean isExtra;
        while (running) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                for (CheeseType value : CheeseType.values()) {
                    if (choice == value.ordinal() &&
                            choice != 0){
                        cheeseChoice = value.getCheese();
                        isExtra = askForExtra(scanner);
                        shawarma.addTopping(new Cheese(cheeseChoice,isExtra));
                        System.out.print(value.ordinal() + " - ");
                        System.out.println(cheeseChoice + " is added");
                        running = false;
                    }
                }
                if (cheeseChoice.isEmpty()){
                    System.out.println("Side is not found.");}
            } catch (Exception e) {
                System.out.println("Enter a number");
            }

        }
    }
    //non-protein toppings methods
    private void otherToppings(Scanner scanner, Shawarma shawarma) {


        boolean running = true;
        String choice;
        while(running) {
            System.out.print("Would you to add a regular topping/veggie? Y/N :");
            choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("y")) {
                addRegularTopping(scanner,shawarma);
                running = false;
            } else if (choice.equalsIgnoreCase("n")) {
                running = false;
            } else System.out.println("Invalid option. Please enter Y or N.");
        }

        running = true;

        while(running) {
            System.out.print("Would you like to add a side? Y/N :");
            choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("y")) {
                addSide(scanner,shawarma);
                running = false;
            } else if (choice.equalsIgnoreCase("n")) {
                running = false;
            } else System.out.println("Invalid option. Please enter Y or N.");
        }
    }

    private void addRegularTopping(Scanner scanner, Shawarma shawarma) {
        System.out.println("Regular topping/vegetable selection:");
        for (VegetableType value : VegetableType.values()) {
            System.out.println(value.ordinal() + " - " + value.getVegetable());
        }
        System.out.println("What side would you like to add? Enter a number");
        String vegetableChoice = "";
        boolean running = true;
        while (running) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                for (VegetableType value : VegetableType.values()) {
                    if (choice == value.ordinal() &&
                            choice != 0){
                        vegetableChoice = value.getVegetable();
                        shawarma.addTopping(new Vegetable(vegetableChoice));
                        System.out.print(value.ordinal() + " - ");
                        System.out.println(vegetableChoice + " is added");
                        running = false;
                    }
                }
                if (vegetableChoice.isEmpty()){
                    System.out.println("Side is not found.");}
            } catch (Exception e) {
                System.out.println("Enter a number");
            }

        }
    }

    private void addSide(Scanner scanner, Shawarma shawarma) {
        System.out.println("Side selection:");
        for (SideType value : SideType.values()) {
            System.out.println(value.ordinal() + " - " + value.getSide());
        }
        System.out.println("What side would you like to add? Enter a number");
        String sideChoice = "";
        boolean running = true;
        while (running) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                for (SideType value : SideType.values()) {
                    if (choice == value.ordinal() &&
                            choice != 0){
                        sideChoice = value.getSide();
                        shawarma.addTopping(new Side(sideChoice));
                        System.out.print(value.ordinal() + " - ");
                        System.out.println(sideChoice + " is added");
                        running = false;
                    }
                }
                if (sideChoice.isEmpty()){
                    System.out.println("Side is not found.");}
            } catch (Exception e) {
                System.out.println("Enter a number");
            }

        }
    }

    private void selectSauces(Scanner scanner, Shawarma shawarma) {
        System.out.println("Sauce selection:");
        for (SauceType value : SauceType.values()) {
            System.out.println(value.ordinal() + " - " + value.getSauce());
        }
        System.out.println("What side would you like to add? Enter a number");

        String sauceChoice = "";
        boolean running = true;
        while (running) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println(choice);
                for (SauceType value : SauceType.values()) {
                    if (choice == value.ordinal() &&
                            choice != 0){
                        sauceChoice = value.getSauce();
                        shawarma.addTopping(new Sauce(sauceChoice));
                        //toppingsList.add(new Sauce(sauceChoice));
                        System.out.print(value.ordinal() + " - ");
                        System.out.println(sauceChoice + " is added");
                        running = false;
                    }
                }
                if (sauceChoice.isEmpty()){
                    System.out.println("Side is not found.");}
            } catch (Exception e) {
                System.out.println("Enter a number");
            }
        }
    }

    private boolean toast(Scanner scanner) {
        System.out.print("Would you like to toast it? Y/N");
        boolean isToasted = false;

        String toasted;
        boolean running = true;
        while(running){
            toasted = scanner.nextLine().trim();
            if(toasted.equalsIgnoreCase("Y")){
                isToasted = true;
                running = false;
            } else if (toasted.equalsIgnoreCase("N")) {
                running = false;
            } else System.out.println("Invalid option. Please Enter Y or N.");
        }
        return isToasted;
    }

    private void addDrink(Scanner scanner, Order order) {
        System.out.println("""
                        Would you like to add a drink?
                        1 - Yes
                        2 - No, back to the Order Screen
                        """
        );
        String kind = "";
        String size = "";
        boolean gettingDrink = true;
        while (gettingDrink) {
            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1" -> {
                    kind = addDrinkKind(scanner);
                    size = addDrinkSize(scanner);
                    gettingDrink = false;
                }
                case "2" -> gettingDrink = false;
                default -> System.out.println("Invalid option. Please enter 1 or 2.");
            }

        }
        order.addDrink(new Drink(kind,size));
    }

    private String addDrinkKind(Scanner scanner) {
        String kind = "";
        boolean running = true;
        System.out.println("""
                            Flavor selection:\
                            t - tea
                            s - soda
                            w - water
                            What flavor would you like?
                            """);
        while (running) {
            String sizeChoice = scanner.nextLine().trim().toLowerCase();
            switch (sizeChoice) {
                case "t" -> {
                    kind = "tea";
                    running = false;
                }
                case "s" -> {
                    kind = "soda";
                    running = false;
                }
                case "w" -> {
                    kind = "water";
                    running = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
        return kind;
    }

    private String addDrinkSize(Scanner scanner) {
        System.out.println("""
                        What size would you like for the drink?\
                        s - small
                        m - medium
                        l - large
                        """);
        String size = "";
        boolean choosingSize = true;
        while (choosingSize)  {
            String sizeChoice = scanner.nextLine().trim().toLowerCase();
            switch (sizeChoice) {
                case "s" -> {
                    size = "small";
                    choosingSize = false;
                }
                case "m" -> {
                    size = "medium";
                    choosingSize = false;
                }
                case "l" -> {
                    size = "large";
                    choosingSize = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
        return size;
    }

    private void addFries(Scanner scanner, Order order) {
        System.out.println("""
                Would you like to add fries?
                1 - Yes
                2 - No, Back to OrderScreen
                """
        );
        boolean running = true;
        while (running) {
            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1" -> {
                    order.addFries(new Fries());
                    running = false;
                }
                case "2" -> {
                    running = false;
                }
                default -> System.out.println("Invalid option. Please enter 1 or 2.");
            }
        }
        System.out.println("Fries added to your order!");
    }

    private void checkout(Scanner scanner, Order order) {
        System.out.println(order);
        System.out.println("1 - Confirm and checkout the order\n" +
                "2 - Cancel the order");
        String choice = scanner.nextLine();
        boolean running = true;
        while (running) {
            if (choice.equalsIgnoreCase("1")){
                if (!order.getShawarmaList().isEmpty() ||
                        !order.getDrinksList().isEmpty() ||
                        !order.getFriesList().isEmpty()){
                    OrderFileManager orderFileManager = new OrderFileManager();
                    orderFileManager.saveOrder(order);
                    running = false;
                }
                else {
                    System.out.println("Order can not be empty.");
                    break;}
            } else if (choice.equalsIgnoreCase("2")) {
                running  = false;
            }
            else {
                System.out.println("Enter 1 or 2");
            }
        }

    }

    private boolean askForExtra(Scanner scanner) {
        System.out.print("Do you want extra for that protein? Y/N:  ");
        boolean isExtra = false;
        boolean running = true;
        String choice;
        while(running) {
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                running = false;
                isExtra = true;
            } else if (choice.equalsIgnoreCase("n")) {
                running = false;
            } else System.out.println("Invalid option. Please enter Y or N.");
        }
        return isExtra;
    }
}



