package com.pluralsight.shop.toppings.regular;

public enum SauceType {
    SKIP("Skip"),MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLANDS("Thousand Islands"),
    VINAIGRETTE("Vinaigrette"),;

    private final String sauce;  // a place to store it

    SauceType(String sauce) {
        this.sauce = sauce;  // store it
    }

    public String getSauce() {
        return sauce;  // retrieve it
    }
}