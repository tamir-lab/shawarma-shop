package com.pluralsight.shop;

import com.pluralsight.shop.items.Drink;
import com.pluralsight.shop.items.Fries;
import com.pluralsight.shop.items.Shawarma;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderName;
    private String orderDate;
    private List<Shawarma> shawarmaList;
    private List<Drink> drinksList;
    private List<Fries> friesList;

    public Order(String orderName, String orderDate) {
        this.orderName = orderName;
        this.orderDate = orderDate;
        shawarmaList = new ArrayList<>();
        drinksList = new ArrayList<>();
        friesList = new ArrayList<>();
    }

    public void addShawarma(Shawarma shawarma){
        shawarmaList.add(shawarma);
    }
    public void addDrink(Drink drink) {
        drinksList.add(drink);
    }
    public void addFries(Fries fries) {
        friesList.add(fries);
    }
}
