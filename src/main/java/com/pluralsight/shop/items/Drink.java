package com.pluralsight.shop.items;

public class Drink {
    private String flavor;
    private String size;

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    public double getValue(String size) {
        switch (size) {
            case "small" -> {return 2.0;}
            case "medium" -> {return 2.5;}
            case "large" -> {return 3.0;}
            default -> {
                return 0;
            }
        }
    }
}
