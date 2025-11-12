package com.pluralsight.shop.toppings.protein;

public enum CheeseType {
    SKIP("Skip"),AKKAWI("Akkawi"),
    HALLOUMI("Halloumi"),
    MOZZARELLA("Mozzarella"),
    FETA("Feta");
    private final String side;  // a place to store it

    CheeseType(String side) {
        this.side = side;  // store it
    }

    public String getCheese() {
        return side;  // retrieve it
    }
}