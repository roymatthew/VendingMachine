package com.vendingmachine.code;

import java.util.List;

public interface VendingMachineInterface 
{
	String powerOn();
	String insertMoney();
	void selectProduct();
	List returnCoins();
}
