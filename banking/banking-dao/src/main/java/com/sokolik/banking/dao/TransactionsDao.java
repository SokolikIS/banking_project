package com.sokolik.banking.dao;

import java.util.List;

import com.sokolik.banking.entity.Transactions;


public interface TransactionsDao {

	public abstract Integer insert(Transactions ob);
	public abstract void update(Transactions ob);
	public abstract void delete(Integer id);
	public abstract Transactions getById(int id);
	public abstract List<Transactions> getAll();
	
}
