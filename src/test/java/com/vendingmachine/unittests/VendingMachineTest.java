package com.vendingmachine.unittests;

import static org.junit.Assert.*;

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
    public void whenInsertCoinsVendingMachineDisplaysCredit() 
    {
        Coin coin = new Coin(5);
        assertNotNull(vendingMachine.insertCoin(coin));
    }	

}
