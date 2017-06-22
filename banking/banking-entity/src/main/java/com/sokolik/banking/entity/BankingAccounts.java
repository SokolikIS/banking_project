package com.sokolik.banking.entity;

public class BankingAccounts {
	
	private int id_account;
	
	private int id_card;
	
	private int id_user;
	
	private int balance;

	public BankingAccounts() {
		
	}

	public BankingAccounts(int id_account, int id_card, int id_user, int balance) {
		this.id_account = id_account;
		this.id_card = id_card;
		this.id_user = id_user;
		this.balance = balance;
	}

	public int getId_account() {
		return id_account;
	}

	public void setId_account(int id_account) {
		this.id_account = id_account;
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + id_account;
		result = prime * result + id_card;
		result = prime * result + id_user;
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
		BankingAccounts other = (BankingAccounts) obj;
		if (balance != other.balance)
			return false;
		if (id_account != other.id_account)
			return false;
		if (id_card != other.id_card)
			return false;
		if (id_user != other.id_user)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankingAccounts [id_account=" + id_account + ", id_card=" + id_card + ", id_user=" + id_user
				+ ", balance=" + balance + "]";
	}
	
}
