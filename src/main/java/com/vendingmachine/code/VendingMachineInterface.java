package com.vendingmachine.code;

import java.util.List;

public interface VendingMachineInterface 
{
	String powerOn();
	String insertCoin(final Coin coin);
	String selectProduct(final Product product);	
	List returnCoins(final Double availableCredit);
    Double getAvailableCredit();
    public Inventory getInventory();    
}
