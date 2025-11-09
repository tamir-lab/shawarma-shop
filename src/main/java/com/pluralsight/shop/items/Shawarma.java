package com.pluralsight.shop.items;

import com.pluralsight.shop.toppings.Topping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        toppings.add(topping);
    }

    @Override
    public String toString() {
        String toastDisplay = isToasted ? " - Toasted": "";
        List<String> toppingPrintable = toppings.stream()
                .map(Topping::toString).toList();
        String toppingString = toppingPrintable.stream().collect(Collectors.joining("\n• ", "• ", ""));
        String printable = String.format("""
                Shawarma
                   Toppings:
                %s
                Subtotal: $%.2f

                """, toppingString,getValue(size));
        return "Shawarma " + size + " - " + breadType + toastDisplay + "\n" +
                "Toppings:\n" + toppingString + getValue(size)
                ;
    }

    public double getValue(String size) {
        return 0;
    }
}
