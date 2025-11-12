package com.pluralsight.shop.items;

public class Drink {
    private String kind;
    private String size;

    public Drink(String flavor, String size) {
        this.kind = flavor;
        this.size = size;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }



    public double getValue() {
        switch (size) {
            case "small" -> {return 2.0;}
            case "medium" -> {return 2.5;}
            case "large" -> {return 3.0;}
            default -> {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return kind + " - " + size + "\n";
    }
}