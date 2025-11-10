package com.pluralsight.shop.toppings;

public enum VegetableType {
    SKIP("Skip"),LETTUCE("Lettuce"),
    PEPPERS("Peppers"),
    ONIONS("Onions"),
    TOMATOES("Tomatoes"),
    JALAPENOS("Jalapeños"),
    CUCUMBERS("Cucumbers"),
    PICKLES("Pickles"),
    GUACAMOLE("Guacamole"),
    MUSHROOMS("Mushrooms");
    private final String vegetable;  // a place to store it

    VegetableType(String vegetable) {
        this.vegetable = vegetable;  // store it
    }

    public String getVegetable() {
        return vegetable;  // retrieve it
    }
}
