package com.vendingmachine.code;

import java.util.Date;

/**
 * Product class.
 * @author rmathew
 */
public class Product 
{
    private ProductEnum id;
    private String name;
    private Date expDate;
    /**
     * Getter for id.
     *
     * @return the id
     */
    public ProductEnum getId()
    {
        return id;
    }
    /**
     * Constructs a ___
     * @param id
     */
    public Product(ProductEnum id)
    {
        super();
        this.id = id;
    }
    /**
     * Setter for id.
     *
     * @param id the id to set
     */
    
    public void setId(ProductEnum id)
    {
        this.id = id;
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
    
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * Getter for expDate.
     *
     * @return the expDate
     */
    public Date getExpDate()
    {
        return expDate;
    }
    /**
     * Setter for expDate.
     *
     * @param expDate the expDate to set
     */
    
    public void setExpDate(Date expDate)
    {
        this.expDate = expDate;
    }    

}
