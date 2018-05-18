package com.vendingmachine.code;

import java.util.List;

public interface VendingMachineInterface 
{
	String powerOn();
	String insertCoin(final Coin coin);
	String selectProduct();
	List returnCoins();
    int getAvailableCredit();	
}
