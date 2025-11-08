package com.pluralsight.shop.toppings;

public class Cheese extends Protein{

    public Cheese(String kind, boolean isExtra) {
        super(kind, isExtra);
    }

    public double getValue(String size) {
        //TODO define pricing for the cheese
        return 0;
    }

}


