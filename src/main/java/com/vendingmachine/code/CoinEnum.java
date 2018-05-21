package com.vendingmachine.code;

public enum CoinEnum
{
    PENNY(1,.01),
    NICKEL(5,.05),
    DIME(10,.10),
    QUARTER(25,.25);
    
    private int weight;
    private Double value;
    /**
     * Enum constructor.
     * @param weight
     * @param value
     */
    private CoinEnum(int weight, double value)
    {
        this.weight = weight;
        this.value = value;
    }
    /**
     * Getter for weight.
     *
     * @return the weight
     */
    public int getWeight()
    {
        return weight;
    }
    /**
     * Setter for weight.
     *
     * @param weight the weight to set
     */
    
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    /**
     * Getter for value.
     *
     * @return the value
     */
    public double getValue()
    {
        return value;
    }
    /**
     * Setter for value.
     *
     * @param value the value to set
     */
    
    public void setValue(double value)
    {
        this.value = value;
    }
    
    public CoinEnum findByWeight(final int coinWeight)
    {
        CoinEnum coinEnum = null;
        if (PENNY.getWeight() == coinWeight)
        {
            coinEnum = PENNY;
        }
        else if (NICKEL.getWeight() == coinWeight)
        {
            coinEnum = NICKEL;
        }
        else if (DIME.getWeight() == coinWeight)
        {
            coinEnum = DIME;
        }
        else if (QUARTER.getWeight() == coinWeight)
        {
            coinEnum = QUARTER;
        }
        return coinEnum;
            
    }
    

}

