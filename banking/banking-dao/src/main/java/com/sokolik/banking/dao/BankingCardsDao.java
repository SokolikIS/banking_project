package com.sokolik.banking.dao;

import java.util.List;

import com.sokolik.banking.entity.BankingCards;


public interface BankingCardsDao {

	public abstract Integer insert(BankingCards ob);
	public abstract void update(BankingCards ob);
	public abstract void delete(Integer id);
	public abstract BankingCards getById(int id);
	public abstract BankingCards getByNumber(String name);
	public abstract List<BankingCards> getAll();
	
}
