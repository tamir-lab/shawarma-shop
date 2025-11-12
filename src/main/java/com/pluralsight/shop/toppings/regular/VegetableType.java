package com.pluralsight.shop.toppings.regular;

public enum VegetableType {
    SKIP("Skip"),PICKLES("Pickles"),
    TOMATOES("Tomatoes"),
    LETTUCE("Lettuce"),
    ONIONS("Onions (raw or sumac-marinated)"),
    CABBAGE("Cabbage"),
    CUCUMBER("Cucumber"),
    PARSLEY("Parsley"),
    TURNIP_PICKLES("Turnip Pickles"),
    MINT_LEAVES("Mint Leaves");
    private final String vegetable;  // a place to store it

    VegetableType(String vegetable) {
        this.vegetable = vegetable;  // store it
    }

    public String getVegetable() {
        return vegetable;  // retrieve it
    }
}