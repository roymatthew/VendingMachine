package com.vendingmachine.code;

import java.util.List;

public class VendingMachine implements VendingMachineInterface 
{
    
    private static final Credit credit = Credit.getInstance();

	public String powerOn() {
		final String message = "Welcome";
		return displayMessage(message);
	}

	private String displayMessage(final String message) {
		
		return message;
	}

	@Override
	public String insertCoin(final Coin coin) {
	    
        switch (getWeight(coin))
        {
            case PENNY:
                break;
            case NICKEL:
                break;
            case DIME:
                break;
            case QUARTER:
                break;
            default:
                break;
        }
		return displayMessage("Credit = 0");		
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
	
	private CoinEnum getWeight(final Coin coin)
	{
	    int weight = 0;
	    
	    return CoinEnum.PENNY;
	}

}
