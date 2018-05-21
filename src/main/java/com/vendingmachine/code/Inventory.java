package com.vendingmachine.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Inventory class.
 */
public class Inventory 
{
    private static final String COLA_STOCK_KEY = "colastock";
    private static final String CHIPS_STOCK_KEY = "chipsstock";
    private static final String CANDY_STOCK_KEY = "candystock";
    
    private static Inventory inventory;
    private static final HashMap<String, List<Product>> productInventory = new HashMap<>();
    
    
    
    /**
     * private Constructor.
     */
    private Inventory()
    {    
        super();       
    }
    
    public static Inventory getInstance()
    {
        if (inventory == null)
        {
            inventory = new Inventory();
            inventory.productInventory.put(COLA_STOCK_KEY, new ArrayList<Product>());
            inventory.productInventory.put(CANDY_STOCK_KEY, new ArrayList<Product>());
            inventory.productInventory.put(CHIPS_STOCK_KEY, new ArrayList<Product>());            
        }
        return inventory;
    }

    private static List<Product> getStockLedger(final ProductEnum productId)
    {
        List<Product> stockLedger= null;
        String stockLedgerKey = null;
        switch (productId)
        {
            case COLA:
                stockLedgerKey = COLA_STOCK_KEY;
                break;
            case CHIPS:
                stockLedgerKey = CHIPS_STOCK_KEY;
                break;
            case CANDY:
                stockLedgerKey = CANDY_STOCK_KEY;
                break;                
            default:
                break;
        }
        
        stockLedger = productInventory.get(stockLedgerKey);
        return stockLedger;
    }
    
    public int getStock(final ProductEnum productId)
    {
        return getStockLedger(productId).size();
    }
    
    public void addProducts(final List<Product> products, final ProductEnum productId)
    {
        getStockLedger(productId).addAll(products);
    }
    
    public boolean removeProduct(final Product product, final ProductEnum productId)
    {
        getStockLedger(productId).remove(product);
        return true;
    }
    
    public void removeAllProducts()
    {
        getStockLedger(ProductEnum.COLA).clear();
        getStockLedger(ProductEnum.CHIPS).clear();
        getStockLedger(ProductEnum.CANDY).clear();        
    }
}
