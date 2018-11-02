package com.supplychain.factory.impl;

import com.google.gson.GsonBuilder;
import com.supplychain.bean.Block;
import com.supplychain.bean.Consignment;
import com.supplychain.factory.BlockChainFactory;
import com.supplychain.utilty.StringUtil;

public class BlockChainFactoryImpl implements BlockChainFactory
{
	public String tranfer(Consignment consignment, String source, String destination, String previousHash) throws Exception
	{
		String calPreviousHash = StringUtil.applySha256(source + consignment.getTag());		
		if(!previousHash.equals(calPreviousHash) && !previousHash.equals("0"))
			throw new Exception("Consignment is tempered");
		
		Block block = new Block(previousHash, consignment, source, destination);

		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(block);
	    System.out.println(blockchainJson);
		return block.hash;
	}
}
