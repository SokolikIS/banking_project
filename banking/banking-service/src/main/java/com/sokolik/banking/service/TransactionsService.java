package com.sokolik.banking.service;

import java.util.List;

import com.sokolik.banking.entity.Transactions;

public interface TransactionsService {

	List<Transactions> getAllTrans();

	Transactions getTransactionById(Integer Id);

	Integer saveTransaction(Transactions trans);

	void deleteTransaction(Integer Id);
	
}
