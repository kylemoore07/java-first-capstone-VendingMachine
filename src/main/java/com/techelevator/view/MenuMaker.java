package com.techelevator.view;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.math.BigDecimal;
import java.util.TreeMap;
import java.util.Scanner;

public class MenuMaker {

    public Map<String, MenuItem> makeVendingItemList() {

        String sourceFilePath = "vendingmachine.csv";
        File vendingItemListFile = new File(sourceFilePath);

        Map<String, MenuItem> menuMap = new TreeMap<>();

        try (Scanner vendingFile = new Scanner(vendingItemListFile)) {

            while (vendingFile.hasNextLine()) {
                String fileLine = vendingFile.nextLine();
                String[] vendingListLines = fileLine.split("\\|");

//                 for (int i = 0; i < vendingListLines.length; i++) {
                MenuItem menuItem = new MenuItem(vendingListLines[0], vendingListLines[1], vendingListLines[3], new BigDecimal(vendingListLines[2]));
                menuMap.put(menuItem.getItemID(), menuItem);

            }

        } catch (FileNotFoundException ex) {
            System.out.println((ex.getMessage()));
        }
        return menuMap;
    }
}


//   public Map<String, MenuItem> makeMenu() {
//
//        MenuItem potatoCrisps = new MenuItem("A1", "Potato Crisps", "Chip", BigDecimal.valueOf(3.05));
//        MenuItem stackers = new MenuItem("A2", "Stackers", "Chip", BigDecimal.valueOf(1.45));
//        MenuItem grainWaves = new MenuItem("A3", "Grain Waves", "Chip", BigDecimal.valueOf(2.75));
//        MenuItem cloudPopcorn = new MenuItem("A4", "Cloud Popcorn", "Chip", BigDecimal.valueOf(3.65));
//
//        MenuItem moonPie = new MenuItem("B1", "Moonpie", "Candy", BigDecimal.valueOf(1.80));
//        MenuItem cowTales = new MenuItem("B2", "Cowtales", "Candy", BigDecimal.valueOf(1.50));
//        MenuItem wonkaBar = new MenuItem("B3", "Wonka Bar", "Candy", BigDecimal.valueOf(1.50));
//        MenuItem crunchie = new MenuItem("B4", "Crunchie", "Candy", BigDecimal.valueOf(1.75));
//
//        MenuItem cola = new MenuItem("C1", "Cola", "Drink", BigDecimal.valueOf(1.25));
//        MenuItem drSalt = new MenuItem("C2", "Dr. Salt", "Drink", BigDecimal.valueOf(1.50));
//        MenuItem mountainMelter = new MenuItem("C3", "Mountain Melter", "Drink", BigDecimal.valueOf(1.50));
//        MenuItem heavy = new MenuItem("C4", "Heavy", "Drink", BigDecimal.valueOf(1.50));
//
//        MenuItem uChews = new MenuItem("D1", "U-Chews", "Gum", BigDecimal.valueOf(0.85));
//        MenuItem littleLeagueChew = new MenuItem("D2", "Little League Chew", "Gum", BigDecimal.valueOf(0.95));
//        MenuItem chiclets = new MenuItem("D3", "Chiclets", "Gum", BigDecimal.valueOf(0.75));
//        MenuItem tripleMint = new MenuItem("D4", "Triplemint", "Gum", BigDecimal.valueOf(0.75));
//
//        /* MAP */
//        Map<String, MenuItem> menuMap = new TreeMap<>();
//
//        menuMap.put(potatoCrisps.getItemID(), potatoCrisps);
//        menuMap.put(stackers.getItemID(), stackers);
//        menuMap.put(grainWaves.getItemID(), grainWaves);
//        menuMap.put(cloudPopcorn.getItemID(), cloudPopcorn);
//
//        menuMap.put(moonPie.getItemID(), moonPie);
//        menuMap.put(cowTales.getItemID(), cowTales);
//        menuMap.put(wonkaBar.getItemID(), wonkaBar);
//        menuMap.put(crunchie.getItemID(), crunchie);
//
//        menuMap.put(cola.getItemID(), cola);
//        menuMap.put(drSalt.getItemID(), drSalt);
//        menuMap.put(mountainMelter.getItemID(), mountainMelter);
//        menuMap.put(heavy.getItemID(), heavy);
//
//        menuMap.put(uChews.getItemID(), uChews);
//        menuMap.put(littleLeagueChew.getItemID(), littleLeagueChew);
//        menuMap.put(chiclets.getItemID(), chiclets);
//        menuMap.put(tripleMint.getItemID(), tripleMint);
//
//
//        return menuMap;
//    }






//        /* Move this somewhere later: */
//        Map<String, String> itemTypePhrases = new HashMap<>();
//        itemTypePhrases.put< "Chip", "Crunch Crunch, Yum!" >
//                itemTypePhrases.put < "Candy", "Munch Munch, Yum!" >
//                itemTypePhrases.put < "Drink", "Glug Glug, Yum!" >
//                itemTypePhrases.put < "Gum", "Chew Chew, Yum!" >