package com.sokolik.banking.dao;

import java.util.List;

import com.sokolik.banking.entity.DelUsers;

public interface DelUsersDao {

	public abstract Integer insert(DelUsers ob);
	public abstract void update(DelUsers ob);
	public abstract void delete(Integer id);
	public abstract DelUsers getById(int id);
	public abstract DelUsers getByLogin(String name);
	public abstract DelUsers getByEmail(String name);
	public abstract List<DelUsers> getAll();
	
}
