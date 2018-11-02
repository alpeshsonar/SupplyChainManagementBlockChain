package com.supplychain;

import com.google.gson.GsonBuilder;
import com.supplychain.bean.Consignment;
import com.supplychain.factory.BlockChainFactory;
import com.supplychain.factory.impl.BlockChainFactoryImpl;

public class Run 
{
	public static void main(String[] args) 
	{
		Consignment consignment = new Consignment();
		consignment.setTag("Consignment 1");
		consignment.setProductName("Mango Seeds");
		consignment.setProductCount(100);
		consignment.setManufacturer("Apple Inc");
		
		try
		{
			BlockChainFactory factory = new BlockChainFactoryImpl();
			
			String hash = "0";
			hash = factory.tranfer(consignment, "Mumbai", "Delhi", hash);
			hash = factory.tranfer(consignment, "Delhi", "Pune", hash);
			hash = factory.tranfer(consignment, "Pune", "Chennai", hash);
		}
		catch(Exception e)
		{
			String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(e);
			System.out.println(blockchainJson);
		}
	}
}
