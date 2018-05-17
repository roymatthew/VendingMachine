package com.vendingmachine.unittests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vendingmachine.code.VendingMachine;

public class VendingMachineTest 
{
	
	private VendingMachine vendingMachine = null;
	
	@Before
	public void setup()
	{
		vendingMachine = new VendingMachine();
	}

	@Test
	public void whenPoweredVendigMachineDisplaysMessage() {
		
		assertNotNull(vendingMachine.powerOn());
	}

}
