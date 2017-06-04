package com.sokolik.banking.service;

import java.util.List;

import com.sokolik.banking.entity.BankingCards;

public interface BankingCardsService {

	List<BankingCards> getAllCards();

	BankingCards getCardById(Integer Id);

	BankingCards getCardByNumber(String num);

	Integer saveCard(BankingCards user);

	void deleteCard(Integer Id);
	
}
