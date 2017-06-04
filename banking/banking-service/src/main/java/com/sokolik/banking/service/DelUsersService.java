package com.sokolik.banking.service;

import java.util.List;

import com.sokolik.banking.entity.DelUsers;

public interface DelUsersService {

	List<DelUsers> getAllUsers();

	DelUsers getUserById(Integer userId);

	DelUsers getUserByLogin(String Name);
	
	DelUsers getUserByEmail(String mail);

	Integer saveUser(DelUsers user);

	void deleteUser(Integer userId);
	
}
