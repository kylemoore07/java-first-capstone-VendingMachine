package com.techelevator;

import com.techelevator.view.MenuItem;
import com.techelevator.view.MenuMaker;

import java.util.Map;

public class VendingMachine {

    private Map<String, MenuItem> menuItemMap;
    private Double totalMoneyProvided = 0.00;


    public Double getTotalMoneyProvided() {
        return totalMoneyProvided;
}

    public Map<String, MenuItem> getMenuItemMap() {
        return menuItemMap;
    }

    public VendingMachine(){
        MenuMaker menuMaker = new MenuMaker();
        menuItemMap = menuMaker.makeVendingItemList();
    }



//TODO couldn't figure out how to access the amount deposited from userInput in CLI to keep track of the total deposit balance

//    public void Balance(){
//        get

//    }




    }
    //keep balance here


//
//    public VendingMachine(){
//
//    }


