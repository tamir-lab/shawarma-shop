package com.pluralsight.shop.toppings.regular;

public enum SideType {
    SKIP("Skip"), AU_JUS("Au Jus"),
    SAUCE("Sauce");
    private final String side;  // a place to store it

    SideType(String side) {
        this.side = side;  // store it
    }

    public String getSide() {
        return side;  // retrieve it
    }
}