package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.MenuItem;


import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	/*
	This is a home Piggy Bank Vending Machine for when you want to go on a diet lol!
	It is always stocked with everything bad that you want, and it allows you to deposit your money
	but you can't select or actually purchase any of the bad stuff out.
	AND you don't get your change when you cancel the transaction haha!
	Not the vending machine that you wanted, but it's the piggy bank vending machine that you got :D lol
	 */

	private Scanner userInput = new Scanner(System.in);
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private String depositAmountInput;
	private Double moneyProvided = 0.00;

	public Double getMoneyProvided() {
		return moneyProvided;
	}

	private Menu menu;
	private VendingMachine vendingMachine = new VendingMachine();

	public Scanner getUserInput() {
		return userInput;
	}
	public String getDepositAmountInput(){
		return depositAmountInput;
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		boolean exit = false;
		while (exit == false) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				/* DISPLAY VENDING MACHINE ITEMS */
				for (Map.Entry<String, MenuItem> entry : vendingMachine.getMenuItemMap().entrySet()) {
					MenuItem item = entry.getValue();

					String inStock = "";

					if (item.getAmountStocked() > 0) {
						inStock = item.getAmountStocked() + " in stock.";
					} else {
						inStock = "Sold out.";
					}
					System.out.println(entry.getKey() + " | " + item.getName() + " | $" + item.getPrice() + " | " + inStock);
				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println();
				System.out.println("Current Money Provided: $" + moneyProvided);
				runPurchaseMenu();


			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				exit = true;
			}
		}
	}

	public void runPurchaseMenu() {
			boolean done = false;

			while (done == false) {
				String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

				System.out.println();
				System.out.println("Current Money Provided: $" + moneyProvided);
				if(choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){

					System.out.println();
					System.out.print("Select Amount To Deposit: (1) $1.00, (2) 5.00, (3) 10.00: ");
					String depositAmountInput = userInput.nextLine();

					if (depositAmountInput.equals("1")){
						moneyProvided += moneyProvided + 1.00;
					} else if(depositAmountInput.equals("2")){
						moneyProvided += moneyProvided + 5.00;
					} else if (depositAmountInput.equals("3")){
						moneyProvided += moneyProvided + 10.00;
					}
				}

				else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
					done = true;
				}

			}
		}
		public static void main (String[] args){
			Menu menu = new Menu(System.in, System.out);
			VendingMachineCLI cli = new VendingMachineCLI(menu);
			cli.run();
		}
}
