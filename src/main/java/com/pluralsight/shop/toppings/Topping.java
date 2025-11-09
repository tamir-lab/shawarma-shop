package com.pluralsight.shop.toppings;

public class Topping {
    private String kind;


    public Topping(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }



    @Override
    public String toString() {
        return  kind + "\n";
    }

}
