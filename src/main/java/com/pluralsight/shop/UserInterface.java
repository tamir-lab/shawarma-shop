package com.pluralsight.shop;

import com.pluralsight.shop.items.Drink;
import com.pluralsight.shop.items.Fries;
import com.pluralsight.shop.items.Shawarma;
import com.pluralsight.shop.toppings.*;


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


        String breadType = selectBread(scanner);
        String size = selectShawarmaSize(scanner);


        List<Topping> toppingsList = new ArrayList<>();


        addAllMeats(scanner,toppingsList);
        addCheese(scanner,toppingsList);

        otherToppings(scanner,toppingsList);
        selectSauces(scanner,toppingsList);
        scanner.nextLine();

        boolean isToasted = toast(scanner);

        Shawarma shawarma;
        shawarma = new Shawarma(breadType,size, isToasted);


        shawarma.setToppings(toppingsList);
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

    public void addAllMeats(Scanner scanner,List<Topping> toppingsList) {
        addMeat(scanner,toppingsList);
        System.out.println("Would you like to add another meat? Y/N");
        String choice;
        boolean running = true;
        while(running) {
            choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("y")) {
                addMeat(scanner,toppingsList);
                running = false;
            } else if (choice.equalsIgnoreCase("n")) {
                running = false;
            } else System.out.println("Invalid option. Please Enter Y or N");
        }
    }

    private void addMeat(Scanner scanner, List<Topping> toppingsList) {
        System.out.println("""
                Selection of meats:
                1 - Chicken (classic marinated in garlic, lemon, and spices)
                2 - Beef (thinly sliced, spiced, and roasted on a vertical spit)
                3 - Lamb (juicy, tender, rich flavor — elite choice)
                4 - Turkey (lighter, smoky variation)
                5 - Veal (milder, buttery texture)""");
        System.out.print("What meat would you like to add?");

        String meatChoice = "";
        boolean isExtra;

        boolean running = true;
        while(running) {
            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1" -> {
                    meatChoice = "Chicken";
                    System.out.println(meatChoice);
                    running = false;
                }
                case "2" -> {
                    meatChoice = "Beef";
                    System.out.println(meatChoice);
                    running = false;
                }
                case "3" -> {
                    meatChoice = "Lamb";
                    System.out.println(meatChoice);
                    running = false;
                }
                case "4" -> {
                    meatChoice = "Turkey";
                    System.out.println(meatChoice);
                    running = false;
                }
                case "5" -> {
                    meatChoice = "Veal";
                    System.out.println(meatChoice);
                    running = false;
                }
                case "" -> {
                    running = false;
                }

                default -> System.out.println("Invalid option. Please enter 1,2,3,4 or 5.");
            }
        }

        isExtra = askForExtra(scanner);
        toppingsList.add(new Meat(meatChoice, isExtra));

    }

    private void addCheese(Scanner scanner, List<Topping> toppingsList) {
        System.out.println("""
                Selection of cheese:
                1 - Akkawi (mild, creamy cheese)
                2 - Halloumi (grilled, slightly salty, squeaky perfection)
                3 - Mozzarella (melty and neutral — not traditional, but popular)
                4 - Feta (crumbly, tangy, pairs well with pickles)""");
        System.out.print("What cheese would you like to add?");
        String cheeseChoice = "";
        boolean isExtra;

        boolean running = true;
        while(running) {
            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1" -> {
                    cheeseChoice = "Akkawi";
                    System.out.println(cheeseChoice);
                    running = false;
                }
                case "2" -> {
                    cheeseChoice = "Halloumi";
                    System.out.println(cheeseChoice);
                    running = false;
                }
                case "3" -> {
                    cheeseChoice = "Mozzarella";
                    System.out.println(cheeseChoice);
                    running = false;
                }
                case "4" -> {
                    cheeseChoice = "Feta";
                    System.out.println(cheeseChoice);
                    running = false;
                }
                case "" -> {
                    running = false;
                }

                default -> System.out.println("Invalid option. Please enter 1,2,3 or 4.");
            }
        }

        isExtra = askForExtra(scanner);
        toppingsList.add(new Cheese(cheeseChoice, isExtra));
    }
    //non-protein toppings methods
    private void otherToppings(Scanner scanner, List<Topping> toppingsList) {


        boolean running = true;
        String choice;
        while(running) {
            System.out.print("Would you to add a regular topping/veggie? Y/N :");
            choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("y")) {
                addRegularTopping(scanner,toppingsList);
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
                addSide(scanner,toppingsList);
                running = false;
            } else if (choice.equalsIgnoreCase("n")) {
                running = false;
            } else System.out.println("Invalid option. Please enter Y or N.");
        }
    }

    private void addRegularTopping(Scanner scanner, List<Topping> toppingsList) {
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
                    if (choice == value.ordinal()){
                        vegetableChoice = value.getVegetable();
                        toppingsList.add(new Side(vegetableChoice));
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

    private void addSide(Scanner scanner, List<Topping> toppingsList) {
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
                    if (choice == value.ordinal()){
                        sideChoice = value.getSide();
                        toppingsList.add(new Side(sideChoice));
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

    private void selectSauces(Scanner scanner, List<Topping> toppingsList) {
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
                for (SauceType value : SauceType.values()) {
                    if (choice == value.ordinal()){
                        sauceChoice = value.getSauce();
                        toppingsList.add(new Side(sauceChoice));
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

    //TODO
    private void checkout(Scanner scanner, Order order) {
        System.out.println(order);
        System.out.println("1 - Confirm and checkout the order\n" +
                           "2 - Cancel the order");

        OrderFileManager blabla = new OrderFileManager();
        blabla.saveOrder(order);

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



