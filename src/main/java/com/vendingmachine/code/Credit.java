
package com.vendingmachine.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Class Credit.
 */
public class Credit
{ 
    private static Credit credit;
    
    private List<Coin> coins;
    
    private Double availableCredit = 0.00;

    /**
     * Getter for coins.
     *
     * @return the coins
     */
    public List<Coin> getCoins()
    {
        return coins;
    }
    
    /**
     * Private constructor.
     */
    private Credit()
    {
        
        super();
        
    }
    
    public static Credit getInstance()
    {
        if (credit == null)
        {
            credit = new Credit();
        }
        return credit;
    }

    /**
     * @param coins the coins to set
     */    
    public void addCoin(final Coin coin)
    {
        if (this.coins == null)
        {
            this.coins = new ArrayList<>();
        }
        
        this.coins.add(coin);
    }    

    /**
     * @param coins the coins to set
     */    
    public void addCoins(final List<Coin> coins)
    {
        if (this.coins == null)
        {
            this.coins = new ArrayList<>();
        }
        this.coins.addAll(coins);
    }
    
    public void resetCredit()
    {
        this.availableCredit = 0.00;
    }
    
    public void subtractCredit(Double price)
    {
        this.availableCredit -= price;
    }

    /**
     * Getter for availableCredit.
     *
     * @return the availableCredit
     */
    public Double getAvailableCredit()
    {
        return availableCredit;
    }

    /**
     * Setter for availableCredit.
     *
     * @param availableCredit the availableCredit to set
     */
    
    public void setAvailableCredit(final Double availableCredit)
    {
        this.availableCredit = availableCredit;
    }
}
