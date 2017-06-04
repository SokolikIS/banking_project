package com.sokolik.banking.entity;





public class Transactions {
	
	
	private int id_transaction;
	
	private int idFrom;

	private int idTo;
	
	private int amount;
	
	public Transactions(int id_transaction, int idFrom, int idTo, int amount) {
		super();
		this.id_transaction = id_transaction;
		this.idFrom = idFrom;
		this.idTo = idTo;
		this.amount = amount;
	}

	public Transactions(int idFrom, int idTo, int amount) {
		super();
		this.idFrom = idFrom;
		this.idTo = idTo;
		this.amount = amount;
	}
	
	public Transactions() {
		
	}

	public int getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}

	public int getIdFrom() {
		return idFrom;
	}

	public void setIdFrom(int idFrom) {
		this.idFrom = idFrom;
	}

	public int getIdTo() {
		return idTo;
	}

	public void setIdTo(int idTo) {
		this.idTo = idTo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + idFrom;
		result = prime * result + idTo;
		result = prime * result + id_transaction;
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
		Transactions other = (Transactions) obj;
		if (amount != other.amount)
			return false;
		if (idFrom != other.idFrom)
			return false;
		if (idTo != other.idTo)
			return false;
		if (id_transaction != other.id_transaction)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transactions [id_transaction=" + id_transaction + ", idFrom=" + idFrom + ", idTo=" + idTo + ", amount="
				+ amount + "]";
	}
	
	
	
	
}
