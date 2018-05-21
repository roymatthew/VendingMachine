package com.vendingmachine.unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

import com.vendingmachine.code.Coin;
import com.vendingmachine.code.Inventory;
import com.vendingmachine.code.Product;
import com.vendingmachine.code.ProductEnum;
import com.vendingmachine.code.VendingMachine;
import com.vendingmachine.code.VendingMachineInterface;

public class VendingMachineTest 
{
	
	private VendingMachineInterface vendingMachine = null;
	
	@Before
	public void setup()
	{
		vendingMachine = new VendingMachine();
	}

	@Test
	public void whenPoweredVendigMachineDisplaysMessage() {
		
		assertNotNull(vendingMachine.powerOn());
	}	

    
    @Test
    public void whenPennyInsertedVendingMachineDisplaysInvalidCredit() 
    {
        Coin coin = new Coin(1);
        assertEquals("Invalid Coin!", vendingMachine.insertCoin(coin));
    }
    
    @Test
    public void whenNickeInsertedVendingMachineDisplaysCredit() 
    {
        Coin coin = new Coin(5);
        assertNotNull(vendingMachine.insertCoin(coin));
    }    
    
    @Test
    public void whenCoinsInsertedVendingMachineDisplaysExactCredit() 
    {
        //user adds 65 cents in total
        List<String> weights = Arrays.asList("5","10","25","25");
        Double insertedCredit = Double.valueOf(.65);
        vendingMachine = new VendingMachine();
        weights.forEach(new Consumer<String>() {

            public void accept(String weight)
            {
                final Coin coin = new Coin(Integer.parseInt(weight));
                vendingMachine.insertCoin(coin);                
            }
            
        });
        
        assertEquals(insertedCredit, vendingMachine.getAvailableCredit());
    }
    
    @Test
    public void whenCandySelectedVendingMachineDisplaysThankYou()
    {
        vendingMachine = new VendingMachine();
        Product candy = new Product(ProductEnum.CANDY);
        List<String> weights = Arrays.asList("5","10","25","25");
        vendingMachine = new VendingMachine();
        addCandyStock(vendingMachine.getInventory()); 
        weights.forEach(new Consumer<String>() {

            public void accept(String weight)
            {
                final Coin coin = new Coin(Integer.parseInt(weight));
                vendingMachine.insertCoin(coin);                
            }
            
        });
        final String message = vendingMachine.selectProduct(candy);
        assertNotNull(message);
        assertEquals("Thank You!", message);
    }
    
    /**
     * If there is not enough credit, machine should ask to insert more coins.
     */
    @Test
    public void whenCandySelectedVendingMachineDisplaysInsertCoin()
    {
        vendingMachine = new VendingMachine();
        Product candy = new Product(ProductEnum.CANDY);
        List<String> weights = Arrays.asList("5","10","25");
        addCandyStock(vendingMachine.getInventory()); 
        weights.forEach(new Consumer<String>() {

            public void accept(String weight)
            {
                final Coin coin = new Coin(Integer.parseInt(weight));
                vendingMachine.insertCoin(coin);                
            }
            
        });
        final String message = vendingMachine.selectProduct(candy);
        assertNotNull(message);
        assertEquals("Insert Coin", message);
    }
    
    /**
     * If product is not available, machine should say product is not available.
     */
    @Test
    public void whenCandySelectedVendingMachineDisplaysNoStock()
    {
        vendingMachine = new VendingMachine();
        Product candy = new Product(ProductEnum.CANDY);
        List<String> weights = Arrays.asList("5","10","25","25");
        //addCandyStock(vendingMachine.getInventory()); 
        weights.forEach(new Consumer<String>() {

            public void accept(String weight)
            {
                final Coin coin = new Coin(Integer.parseInt(weight));
                vendingMachine.insertCoin(coin);                
            }
            
        });
        final String message = vendingMachine.selectProduct(candy);
        assertNotNull(message);
        assertEquals("Sorry, product not in stock.", message);
    }    

    /**
     * This method ___
     * @param inventory 
     */
    
    private void addCandyStock(final Inventory inventory)
    {
        final List<Product> products = new ArrayList<>(2);
        Product product1 = new Product(ProductEnum.CANDY);
        Product product2 = new Product(ProductEnum.CANDY);
        products.add(product1);
        products.add(product2);
        
        inventory.addProducts(products, ProductEnum.CANDY);
        
        
    }

}
