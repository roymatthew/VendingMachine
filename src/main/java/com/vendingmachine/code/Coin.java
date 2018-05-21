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
    private String name;
    private double value;
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
    public double getValue()
    {
        return value;
    }
    /**
     * Setter for value.
     *
     * @param value the value to set
     */
    
    public void setValue(final double value)
    {
        this.value = value;
    }
    /**
     * Getter for name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Setter for name.
     *
     * @param name the name to set
     */
    
    public void setName(final String name)
    {
        this.name = name;
    }
}
