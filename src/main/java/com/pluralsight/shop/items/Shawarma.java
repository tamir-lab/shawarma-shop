package com.pluralsight.shop.items;

import com.pluralsight.shop.toppings.Protein;
import com.pluralsight.shop.toppings.Topping;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public String toString() {

        String toastDisplay = isToasted() ? " - Toasted": " ";
        List<String> toppingPrintable = getToppings().stream()
                .map(Topping::toString).toList();
        String toppingString = toppingPrintable.stream().collect(Collectors.joining("\n• ", "• ", ""));
        //null issue
        return String.format("""
                        Shawarma %s - %s %s
                           Toppings:
                             %s
                             $%.2f
        
                        """, getSize(),getBreadType(),toastDisplay,toppingString,getValue());
    }

    public double getValue() {
        double baseValue = 0;
        switch (getSize()) {
            case "small" -> {
                baseValue = 5.50;
            }
            case "regular" -> {
                baseValue = 7.00;
            }
            case "large" -> {
                baseValue = 8.50;
            }
        }
        double toppingValue = toppings.stream()
                //getting the list of proteins
                .filter(item -> item instanceof Protein)
                .map(item -> (Protein) item)
                .toList()
                //getting the list of values for each protein
                .stream().map(p -> p.getValue(getSize())).toList().stream()
                //calculating the total for all values
                .reduce((double) 0,
                        (temp,num) -> temp += num);


        return baseValue + toppingValue;
    }
}
