package com.pluralsight.shop;

import com.pluralsight.shop.items.Drink;
import com.pluralsight.shop.items.Fries;
import com.pluralsight.shop.items.Shawarma;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Shawarma> getShawarmaList() {
        return shawarmaList;
    }

    public void setShawarmaList(List<Shawarma> shawarmaList) {
        this.shawarmaList = shawarmaList;
    }

    public List<Drink> getDrinksList() {
        return drinksList;
    }

    public void setDrinksList(List<Drink> drinksList) {
        this.drinksList = drinksList;
    }

    public List<Fries> getFriesList() {
        return friesList;
    }

    public void setFriesList(List<Fries> friesList) {
        this.friesList = friesList;
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
    public double getTotal() {
        return 11;
    }

    @Override
    public String toString() {
        String shawarmaPrintable = "";


        String drinkPrintable = drinksList.stream()
                .map(Drink::toString)   // extract the string from each object
                .collect(Collectors.joining("\n")) +
                "\nSubtotal: $" +
                drinksList.stream()
                        .map(Drink::getValue).toList().stream()
                        .reduce((double) 0,
                                (temp,num) -> temp += num);

        String friesPrintable = "Fries x" + friesList.size() +
                "\nSubtotal: $" +
                friesList.stream()
                        .map(Fries::getPrice).toList().stream()
                        .reduce((double) 0,
                                (temp,num) -> temp += num);

        return String.format("""
                 Items:
                %s
                
                %s
                
                %s


                ------------------------------------------
                Subtotal:               $%.2f
                Tax (5%%):              $%.2f
                ------------------------------------------
                TOTAL:                  $%.2f
                ------------------------------------------""",
                shawarmaList,
                drinkPrintable,
                friesPrintable,
                getTotal(),
                getTotal()/20,
                getTotal()*1.05);
    }
}

