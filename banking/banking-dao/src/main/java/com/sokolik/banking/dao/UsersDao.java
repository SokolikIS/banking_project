package com.sokolik.banking.dao;

import java.util.List;

import com.sokolik.banking.entity.Users;

public interface UsersDao {
	
	public abstract Integer insert(Users ob);
	public abstract void update(Users ob);
	public abstract void delete(Integer userId);
	public abstract Users getById(int id);
	public abstract Users getByLogin(String name);
	public abstract List<Users> getAll();
	
}
