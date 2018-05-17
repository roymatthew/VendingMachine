package com.vendingmachine.code;

public class Coin 
{
    /**
     * Constructor using weight.
     * @param weight
     */
    public Coin(int weight)
    {
        super();
        this.weight = weight;
    }
    private int weight;
    private int name;
    private int value;
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
    
    public void setWeight(final int weight)
    {
        this.weight = weight;
    }
    /**
     * Getter for value.
     *
     * @return the value
     */
    public int getValue()
    {
        return value;
    }
    /**
     * Setter for value.
     *
     * @param value the value to set
     */
    
    public void setValue(final int value)
    {
        this.value = value;
    }
    /**
     * Getter for name.
     *
     * @return the name
     */
    public int getName()
    {
        return name;
    }
    /**
     * Setter for name.
     *
     * @param name the name to set
     */
    
    public void setName(final int name)
    {
        this.name = name;
    }
}
