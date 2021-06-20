package com.service;

import org.springframework.stereotype.Service;

import com.entities.Customer;
import com.entities.User;

@Service
public interface UserService {
	
	public User createUser(User u);
	public Customer signIn(int userId,String password) throws Exception;
	public User changeUserpassword(int userId,String password,String newpassword) throws Exception;
	public User signOut(int userId) throws Exception;

	
}
