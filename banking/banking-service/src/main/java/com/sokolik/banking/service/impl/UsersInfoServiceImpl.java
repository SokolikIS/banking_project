package com.sokolik.banking.service.impl;

import java.util.List;

import com.sokolik.banking.dao.UsersInfoDao;
import com.sokolik.banking.entity.UsersInfo;
import com.sokolik.banking.service.UsersInfoService;

public class UsersInfoServiceImpl implements UsersInfoService{

	private UsersInfoDao usersInfoDao;
	
	public void setUsersInfoDao(UsersInfoDao usersInfoDao) {
		this.usersInfoDao = usersInfoDao;
	}

	@Override
	public List<UsersInfo> getAllUsers() {
		return usersInfoDao.getAll();
	}

	@Override
	public UsersInfo getUserById(Integer userId) {
		return usersInfoDao.getById(userId);
	}

	@Override
	public UsersInfo getUserByEmail(String mail) {
		return usersInfoDao.getByEmail(mail);
	}

	@Override
	public Integer saveUser(UsersInfo user) {
		if (user.getId() == 0) {
			return usersInfoDao.insert(user);
		}
		
		usersInfoDao.update(user);
		return user.getId();
	}

	@Override
	public void deleteUser(Integer userId) {
		usersInfoDao.delete(userId);
	}

	
	
}
