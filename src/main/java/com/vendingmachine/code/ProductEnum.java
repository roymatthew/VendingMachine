package com.vendingmachine.code;

public enum ProductEnum
{
    COLA("C0123", 1.00),
    CHIPS("C0234", .50),
    CANDY("C0345", .65);
    
    private String upc;
    private Double price;
    
    /**
     * constructor using fields.
     * @param name
     * @param price
     */
    private ProductEnum(final String upc, final Double price)
    {
        this.upc = upc;
        this.price = price;
    }

    /**
     * Getter for upc.
     *
     * @return the upc
     */
    public String getUpc()
    {
        return upc;
    }

    /**
     * Setter for upc.
     *
     * @param upc the upc to set
     */
    
    public void setUpc(String upc)
    {
        this.upc = upc;
    }

    /**
     * Getter for price.
     *
     * @return the price
     */
    public Double getPrice()
    {
        return price;
    }

    /**
     * Setter for price.
     *
     * @param price the price to set
     */
    
    public void setPrice(Double price)
    {
        this.price = price;
    }


}

