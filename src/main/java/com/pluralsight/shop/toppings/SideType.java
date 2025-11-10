package com.pluralsight.shop.toppings;

public enum SideType {
    SKIP("Skip"), TABBOULEH("Tabbouleh"),HUMMUS_WITH_PITA("Hummus with pita") ;
    private final String side;  // a place to store it

    SideType(String side) {
        this.side = side;  // store it
    }

    public String getSide() {
        return side;  // retrieve it
    }
}
