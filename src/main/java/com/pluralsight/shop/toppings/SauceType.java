package com.pluralsight.shop.toppings;

public enum SauceType {
 SKIP("Skip"),TOUM("Toum"),TAHINI_SAUCE("Tahini sauce"),GARLIC_YOGURT("Garlic yogurt"),
 SPICY_HARRISA("Spicy harrisa"),POMEGRANATE_MOLASSES("Pomegranate molasses"),
 SUMAC_MAYO("Spicy mayo");

 private final String sauce;  // a place to store it

 SauceType(String sauce) {
  this.sauce = sauce;  // store it
 }

 public String getSauce() {
  return sauce;  // retrieve it
 }
}
