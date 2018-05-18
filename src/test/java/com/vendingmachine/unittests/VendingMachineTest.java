package com.vendingmachine.unittests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

import com.vendingmachine.code.Coin;
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
        vendingMachine = new VendingMachine();
        //vendingMachine.getCredit().resetCredit();
        weights.forEach(new Consumer<String>() {

            public void accept(String weight)
            {
                final Coin coin = new Coin(Integer.parseInt(weight));
                vendingMachine.insertCoin(coin);                
            }
            
        });
        
        assertTrue(65 == vendingMachine.getAvailableCredit());
    }
    @Test
    public void whenProductSelectedVendingMachineDisplaysMessage()
    {
        assertNotNull(vendingMachine.selectProduct());
    }

}
