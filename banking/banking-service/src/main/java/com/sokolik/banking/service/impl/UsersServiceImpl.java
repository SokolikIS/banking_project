package com.sokolik.banking.service.impl;

import java.util.List;

import com.sokolik.banking.dao.UsersDao;
import com.sokolik.banking.entity.Users;
import com.sokolik.banking.service.UsersService;

public class UsersServiceImpl implements UsersService{

	private UsersDao usersDao;
	
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public List<Users> getAllUsers() {
		return usersDao.getAll();
	}

	@Override
	public Users getUserById(Integer userId) {
		return usersDao.getById(userId);
	}

	@Override
	public Users getUserByLogin(String userName) {
		return usersDao.getByLogin(userName);
	}

	@Override
	public Integer saveUser(Users user) {
		if (user.getId() == 0) {
			return usersDao.insert(user);
		}
		
		usersDao.update(user);
		return user.getId();
		
	}

	@Override
	public void deleteUser(Integer userId) {
		usersDao.delete(userId);
	}

	
	
}

