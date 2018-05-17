package com.vendingmachine.code;

import java.util.List;

public interface VendingMachineInterface 
{
	String powerOn();
	String insertCoin(final Coin coin);
	void selectProduct();
	List returnCoins();
    int getAvailableCredit();	
}
