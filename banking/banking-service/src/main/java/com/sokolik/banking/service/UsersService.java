package com.sokolik.banking.service;

import java.util.List;

import com.sokolik.banking.entity.Users;

public interface UsersService {

	List<Users> getAllUsers();

	Users getUserById(Integer userId);

	Users getUserByLogin(String userName);

	Integer saveUser(Users user);

	void deleteUser(Integer userId);
	
}
