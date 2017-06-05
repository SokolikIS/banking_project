package com.sokolik.banking.service.impl;

import java.util.List;

import com.sokolik.banking.dao.DelUsersDao;
import com.sokolik.banking.entity.DelUsers;
import com.sokolik.banking.service.DelUsersService;

public class DelUsersServiceImpl implements DelUsersService{

	private DelUsersDao delUsersDao;
	
	public void setDelUsersDao(DelUsersDao delUsersDao) {
		this.delUsersDao = delUsersDao;
	}

	@Override
	public List<DelUsers> getAllUsers() {
		return delUsersDao.getAll();
	}

	@Override
	public DelUsers getUserById(Integer userId) {
		return delUsersDao.getById(userId);
	}

	@Override
	public DelUsers getUserByLogin(String Name) {
		return delUsersDao.getByLogin(Name);
	}

	@Override
	public DelUsers getUserByEmail(String mail) {
		return delUsersDao.getByEmail(mail);
	}

	@Override
	public Integer saveUser(DelUsers user) {
		if (user.getId() == 0) {
			return delUsersDao.insert(user);
		}
		
		delUsersDao.update(user);
		return user.getId();
	}

	@Override
	public void deleteUser(Integer userId) {
		delUsersDao.delete(userId);
		
	}

	
	
}
