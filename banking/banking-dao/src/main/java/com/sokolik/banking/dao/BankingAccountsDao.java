package com.sokolik.banking.dao;

import java.util.List;

import com.sokolik.banking.entity.BankingAccounts;

public interface BankingAccountsDao {

	public abstract Integer insert(BankingAccountsDao ob);
	public abstract void update(BankingAccountsDao ob);
	public abstract void delete(Integer id);
	public abstract BankingAccounts getByIdAcc(int id);
	public abstract BankingAccounts getByIdCard(int idCard);
	public abstract BankingAccounts getByIdUser(int idUser);
	public abstract List<BankingAccounts> getAll();
	
	
}
