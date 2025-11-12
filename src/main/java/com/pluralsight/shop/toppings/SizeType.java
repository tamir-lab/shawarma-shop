package com.pluralsight.shop.toppings;

public enum SizeType {
    SMALL("Small (5-6 inches)"),
    REGULAR("Regular (8-9 inches)"),
    LARGE("Large (12 inches or more)");

    private final String size;  // a place to store it

    SizeType(String size) {
        this.size = size;  // store it
    }

    public String getSize() {
        return size;  // retrieve it
    }
}