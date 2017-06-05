package com.sokolik.banking.service.impl;

import java.util.List;

import com.sokolik.banking.dao.TransactionsDao;
import com.sokolik.banking.entity.Transactions;
import com.sokolik.banking.service.TransactionsService;

public class TransactionsServiceImpl implements TransactionsService{

	private TransactionsDao transactionsDao;
	
	@Override
	public List<Transactions> getAllTrans() {
		return transactionsDao.getAll();
	}

	@Override
	public Transactions getTransactionById(Integer Id) {
		return transactionsDao.getById(Id);
	}

	@Override
	public Integer saveTransaction(Transactions trans) {
		if (trans.getId_transaction() == 0){
			return transactionsDao.insert(trans);
		}
		transactionsDao.update(trans);
		return trans.getId_transaction();
	}

	@Override
	public void deleteTransaction(Integer Id) {
		transactionsDao.delete(Id);	
		
	}

	
	
}
