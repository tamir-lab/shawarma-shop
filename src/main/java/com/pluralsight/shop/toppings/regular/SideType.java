package com.pluralsight.shop.toppings.regular;

public enum SideType {
    SKIP("Skip"), TABBOULEH("Tabbouleh"),
    HUMMUS_WITH_PITA("Hummus with Pita");
    private final String side;  // a place to store it

    SideType(String side) {
        this.side = side;  // store it
    }

    public String getSide() {
        return side;  // retrieve it
    }
}