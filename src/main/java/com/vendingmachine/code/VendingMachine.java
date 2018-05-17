package com.vendingmachine.code;

import java.util.List;

public class VendingMachine implements VendingMachineInterface {

	public String powerOn() {
		final String message = "Welcome";
		return displayMessage(message);
	}

	private String displayMessage(final String message) {
		
		return message;
	}

	@Override
	public String insertMoney() {
		return null;		
	}

	@Override
	public void selectProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List returnCoins() {
		// TODO Auto-generated method stub
		return null;
	}

}
