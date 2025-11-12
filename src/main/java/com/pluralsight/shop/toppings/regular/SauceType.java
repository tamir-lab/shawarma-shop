package com.pluralsight.shop.toppings.regular;

public enum SauceType {
    SKIP("Skip"),TOUM("Toum (Garlic Sauce)"),
    TAHINI("Tahini Sauce"),
    GARLIC_YOGURT("Garlic Yogurt"),
    HARISSA("Spicy Harissa"),
    POMEGRANATE_MOLASSES("Pomegranate Molasses"),
    SUMAC_MAYO("Sumac Mayo");

    private final String sauce;  // a place to store it

    SauceType(String sauce) {
        this.sauce = sauce;  // store it
    }

    public String getSauce() {
        return sauce;  // retrieve it
    }
}