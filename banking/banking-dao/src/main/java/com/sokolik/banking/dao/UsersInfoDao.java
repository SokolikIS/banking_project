package com.sokolik.banking.dao;

import java.util.List;

import com.sokolik.banking.entity.UsersInfo;

public interface UsersInfoDao {
	
	public abstract Integer insert(UsersInfo ob);
	public abstract void update(UsersInfo ob);
	public abstract void delete(Integer id);
	public abstract UsersInfo getById(int id);
	public abstract UsersInfo getByEmail(String name);
	public abstract List<UsersInfo> getAll();
	
}
