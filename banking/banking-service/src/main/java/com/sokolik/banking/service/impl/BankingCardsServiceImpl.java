package com.sokolik.banking.service.impl;

import java.util.List;

import com.sokolik.banking.dao.BankingCardsDao;
import com.sokolik.banking.entity.BankingCards;
import com.sokolik.banking.service.BankingCardsService;

public class BankingCardsServiceImpl implements BankingCardsService{

	private BankingCardsDao bankingCardsDao;
	
	public void setBankingCardsDao(BankingCardsDao bankingCardsDao) {
		this.bankingCardsDao = bankingCardsDao;
	}

	@Override
	public List<BankingCards> getAllCards() {
		return bankingCardsDao.getAll();
	}

	@Override
	public BankingCards getCardById(Integer Id) {
		return bankingCardsDao.getById(Id);
	}

	@Override
	public BankingCards getCardByNumber(String num) {
		return bankingCardsDao.getByNumber(num);
	}

	@Override
	public Integer saveCard(BankingCards user) {
		if (user.getId_card() == 0){
			return bankingCardsDao.insert(user);
		}
		
		bankingCardsDao.update(user);
		return user.getId_card();
	}

	@Override
	public void deleteCard(Integer Id) {
		bankingCardsDao.delete(Id);
		
	}

	
	
}
