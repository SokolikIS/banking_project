package com.sokolik.banking.service;

import java.util.List;

import com.sokolik.banking.entity.UsersInfo;

public interface UsersInfoService {
	
	List<UsersInfo> getAllUsers();

	UsersInfo getUserById(Integer userId);

	UsersInfo getUserByEmail(String mail);

	Integer saveUser(UsersInfo user);

	void deleteUser(Integer userId);
	
}
