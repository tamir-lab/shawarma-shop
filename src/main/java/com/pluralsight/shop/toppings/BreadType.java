package com.pluralsight.shop.toppings;

public enum BreadType {
    PITA("Pita Bread"),
    MARKOUK("Markouk (Saj Bread)"),
    LAVASH("Lavash"),
    TANOUR("Tannour Bread");
    private final String bread;

    BreadType(String bread) {
        this.bread = bread;  // store it
    }

    public String getBread() {
        return bread;  // retrieve it
    }
}