package com.pluralsight.shop.toppings.protein;

public class Cheese extends Protein {

    public Cheese(String kind, boolean isExtra) {
        super(kind, isExtra);
    }

    public double getValue(String size) {
        double value = 0;
        switch (size) {
            case "small" -> {
                if(isExtra()){
                    value = 0.75 + 0.3;
                } else {
                    value = 0.75;
                }
            }
            case "regular" -> {
                if(isExtra()){
                    value = 1.5 + 0.6;
                } else {
                    value = 1.5;
                }
            }
            case "large" -> {
                if(isExtra()){
                    value = 2.25 +0.9;
                } else {
                    value = 2.25;
                }
            }
            default -> System.out.println("error calculating cheese price");
        }
        return value;
    }

}

