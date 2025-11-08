package com.pluralsight.shop.items;

import com.pluralsight.shop.toppings.Topping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shawarma {
    private String breadType;
    private String size;
    private boolean isToasted;
    private List<Topping> toppings;

    public Shawarma(String breadType, String size, boolean isToasted) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        toppings = new ArrayList<>();
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
    public void addTopping(Topping topping) {
        //TODO define the method "question -> add"

        toppings.add(topping);
    }

    @Override
    public String toString() {
        return "Shawarma{" +
                "breadType='" + breadType + '\'' +
                ", size='" + size + '\'' +
                ", isToasted=" + isToasted +
                ", toppings=" + toppings +
                '}';
    }

    public double getValue(String size) {
        return 0;
    }
}
