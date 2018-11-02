package com.supplychain.factory;


import com.supplychain.bean.Consignment;

public interface BlockChainFactory {

	public String tranfer(Consignment consignment, String source, String destination, String previousHash) throws Exception;
}
