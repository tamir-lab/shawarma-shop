package com.pluralsight.shop.toppings;

public enum VegetableType {
    SKIP("Skip"),PICKLES("Pickles"), TOMATOES("Tomatoes"),LETTUCE("Lettuce"),
    ONIONS("Onions"), CABBAGE("Cabbage"), CUCUMBER("Cucumber"),
    PARSLEY("Parsley"), TURNIP_PICKLES("Turnip Pickles"), MINT_LEAVES("Mint leaves");
    private final String vegetable;  // a place to store it

    VegetableType(String vegetable) {
        this.vegetable = vegetable;  // store it
    }

    public String getVegetable() {
        return vegetable;  // retrieve it
    }
}
