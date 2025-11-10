package com.pluralsight.shop.toppings;

public enum CheeseType {
     SKIP("Skip"),AMERICAN("American"),
     PROVOLONE("Provolone"),
     CHEDDAR("Cheddar"),
     SWISS("Swiss");
     private final String side;  // a place to store it

     CheeseType(String side) {
          this.side = side;  // store it
     }

     public String getCheese() {
          return side;  // retrieve it
     }
}
