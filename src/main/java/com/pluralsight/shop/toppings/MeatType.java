package com.pluralsight.shop.toppings;

public enum MeatType {
    SKIP("Skip"),CHICKEN("Chicken"),BEEF("Beef"),
    LAMB("Lamb"),TURKEY("Turkey"),VEAL("Veal");
    private final String meat;  // a place to store it

    MeatType(String meat) {
        this.meat = meat;  // store it
    }

    public String getMeat() {
        return meat;  // retrieve it
    }
}
