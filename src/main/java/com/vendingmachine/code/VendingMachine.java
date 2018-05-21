package com.vendingmachine.code;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine implements VendingMachineInterface 
{
    
    private Credit credit;
    private Inventory inventory;

	public String powerOn() {
		final String message = "Welcome";
        credit = Credit.getInstance();
        credit.resetCredit();
        inventory = Inventory.getInstance();        
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
        inventory = Inventory.getInstance();
        inventory.removeAllProducts();
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
     * 
     * @param coin
     */

    private void updateCredit(final Coin coin)
    {
        credit.addCoin(coin);
        credit.setAvailableCredit(Double.sum(credit.getAvailableCredit().doubleValue(), coin.getValue()));

    }

    @Override
	public String selectProduct(final Product product) 
    {
        
        System.out.println("Enter selectProduct. Available credit: " + credit.getAvailableCredit());
        System.out.println("Price of product requested: " + product.getId().getPrice());
        

        if (inventory.getStock(product.getId()) == 0)
        {
            return displayMessage("Sorry, product not in stock."); 
        }
        else if (credit.getAvailableCredit() == 0.00
            || credit.getAvailableCredit().compareTo(product.getId().getPrice()) < 0)
        {
            return displayMessage("Insert Coin");
        }
        else
        {
            if (dispenseProduct(product))
            {
                credit.subtractCredit(product.getId().getPrice());
                returnCoins(credit.getAvailableCredit());
                return displayMessage("Thank You!");
            }
            else
            {
                returnCoins(credit.getAvailableCredit());
                return displayMessage("Sorry, we are having some technical issues with the machine. "
                + "Please try again later.");                
            }
            
        }
	}

	/**
     * This method ___
	 * @param product 
     */    
    private boolean dispenseProduct(final Product product)
    {
        inventory.removeProduct(product, product.getId());
        return dropProductToDispeserWindow(product);
        
    }

    /**
     * This method ___
     * @param product
     * @return
     */
    
    private boolean dropProductToDispeserWindow(final Product product)
    {
        // check that product is dropped in (either check weight or do a scan)
        //and available for pickup
        return true;
        
    }

    @Override
	public List<Coin> returnCoins(final Double availableCredit) {
        
		// convert available credit to coins
        // return the collection of coins
		return new ArrayList<>();
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


    public Double getAvailableCredit()
    {
        return this.credit.getAvailableCredit();
    }

    /**
     * Getter for inventory.
     *
     * @return the inventory
     */
    public Inventory getInventory()
    {
        return inventory;
    }


}
