package com.techelevator.view;

import java.math.BigDecimal;

public class MenuItem {

    private String itemID;
    private String name;
    private String itemType;  /* May be Chip, Candy, Drink, or Gum */
    private BigDecimal price;
    private int amountStocked;

    public MenuItem (String itemID, String name, String itemType, BigDecimal price){
        this.itemID = itemID;
        this.name = name;
        this.itemType = itemType;
        this.price = price;
        this.amountStocked = 5;
    }


    /* GETTERS AND SETTERS */
    public String getName() {
        return name;
    }
    public String getItemID() {
        return itemID;
    }
    public String getItemType() {
        return itemType;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public int getAmountStocked() {
        return amountStocked;
    }

    public void setName(String newName) {
        name = newName;
    }
    public void setItemID(String newID) {
        itemID = newID;
    }

//    public void setPrice(BigDecimal newPrice) {
//        price = newPrice;
//    }

}
