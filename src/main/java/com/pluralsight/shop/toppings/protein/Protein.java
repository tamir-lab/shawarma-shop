package com.pluralsight.shop.toppings.protein;

import com.pluralsight.shop.toppings.Topping;

public abstract class Protein extends Topping {
    private boolean isExtra;

    public Protein(String kind, boolean isExtra) {
        super(kind);
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public abstract double getValue(String size);

    @Override
    public String toString() {
        String extra = isExtra ? " (extra)": "";
        return getKind()  + extra + "\n";
    }
}