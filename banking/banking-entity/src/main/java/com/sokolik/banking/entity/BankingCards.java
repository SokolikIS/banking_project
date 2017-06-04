package com.sokolik.banking.entity;




public class BankingCards {
	
	private int id_card;
	
	private int id_user;
	
	private String number;
	
	private String date;
	
	private int currency;

	public BankingCards() {
	}

	public BankingCards(int id_user, String number, String date) {

		this.id_user = id_user;
		this.number = number;
		this.date = date;

	}

	public BankingCards(int id_user, String number, String date, int currency) {

		this.id_user = id_user;
		this.number = number;
		this.date = date;
		this.currency = currency;
	}

	public BankingCards(int id_card, int id_user, String number, String date, int currency) {

		this.id_card = id_card;
		this.id_user = id_user;
		this.number = number;
		this.date = date;
		this.currency = currency;
	}

	public int getId_card() {
		return id_card;
	}

	public void setId_card(int id_card) {
		this.id_card = id_card;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currency;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id_card;
		result = prime * result + id_user;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankingCards other = (BankingCards) obj;
		if (currency != other.currency)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id_card != other.id_card)
			return false;
		if (id_user != other.id_user)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cards [id_card=" + id_card + ", id_user=" + id_user + ", number=" + number + ", date=" + date
				+ ", currency=" + currency + "]";
	}

}
