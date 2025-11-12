package com.pluralsight.shop.toppings.protein;

public class Meat extends Protein {

    public Meat(String kind, boolean isExtra) {
        super(kind, isExtra);
    }


    public double getValue(String size) {
        double value = 0;
        switch (size) {
            case "small" -> {
                if(isExtra()){
                    value = 1*1.5;
                } else {
                    value = 1;
                }
            }
            case "regular" -> {
                if(isExtra()){
                    value = 2*1.5;
                } else {
                    value = 2;
                }
            }
            case "large" -> {
                if(isExtra()){
                    value = 3*1.5;
                } else {
                    value = 3;
                }
            }
            default -> System.out.println("error calculating cheese price");
        }
        return value;
    }

}
