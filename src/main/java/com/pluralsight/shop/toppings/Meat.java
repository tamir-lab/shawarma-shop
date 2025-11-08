package com.pluralsight.shop.toppings;

public class Meat extends Protein {

    public Meat(String kind, boolean isExtra) {
        super(kind, isExtra);
    }


    public double getValue(String size) {
        return 0;
    }
}
