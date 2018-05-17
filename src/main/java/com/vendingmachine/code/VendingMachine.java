package com.vendingmachine.code;

import java.util.List;

public class VendingMachine implements VendingMachineInterface 
{
    
    private Credit credit;

	public String powerOn() {
		final String message = "Welcome";
        credit = Credit.getInstance();
        credit.resetCredit();
		return displayMessage(message);
	}

	private String displayMessage(final String message) {
		
		return message;
	}

	/**
     * Constructor.
     */
    public VendingMachine()
    {        
        super();
        credit = Credit.getInstance();
        credit.resetCredit();
    }

    @Override
	public String insertCoin(final Coin coin) 
	{
	    
        switch (getWeight(coin))
        {
            case PENNY:
                coin.setName("Penny");
                coin.setValue(CoinEnum.PENNY.getValue());
                break;
            case NICKEL:
                coin.setName("Nickel");
                coin.setValue(CoinEnum.NICKEL.getValue());                
                break;
            case DIME:
                coin.setName("Dime");
                coin.setValue(CoinEnum.DIME.getValue());                
                break;
            case QUARTER:
                coin.setName("Quarter");
                coin.setValue(CoinEnum.QUARTER.getValue());                
                break;
            default:
                break;
        }
        System.out.println("A " + coin.getName() + " was inserted.");        
        if (VendingMachineConstants.PENNY_NAME.equals(coin.getName()))
        {
            return displayMessage("Invalid Coin!");
        }
        updateCredit(coin);
        System.out.println(credit.getAvailableCredit());
		return displayMessage("Credit = " + credit.getAvailableCredit());		
	}

	/**
     * This method ___
     * @param coin
     */
    
    private void updateCredit(final Coin coin)
    {
        credit.addCoin(coin);
        credit.setAvailableCredit(credit.getAvailableCredit() + coin.getValue());
        
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
	    
	    CoinEnum coinEnum = null;
	    
	    if (VendingMachineConstants.PENNY_WT == coin.getWeight())
	    {
	        coinEnum = CoinEnum.PENNY;
	    }
	    else if (VendingMachineConstants.NICKEL_WT == coin.getWeight())
	    {
            coinEnum = CoinEnum.NICKEL; 
	    }
        else if (VendingMachineConstants.DIME_WT == coin.getWeight())
        {
            coinEnum = CoinEnum.DIME;
        }
        else if (VendingMachineConstants.QUARTER_WT == coin.getWeight())
        {
            coinEnum = CoinEnum.QUARTER; 
        }	    
	    
	    return coinEnum;
	}

    /**
     * Getter for credit.
     *
     * @return the credit
     */
    public Credit getCredit()
    {
        return this.credit;
    }


    public int getAvailableCredit()
    {
        return this.credit.getAvailableCredit();
    }

}
