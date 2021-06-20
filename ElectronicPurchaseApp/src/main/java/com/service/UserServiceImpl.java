package com.service;

import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Customer;
import com.entities.User;
import com.error.ResourceNotFoundException;
import com.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userrepository;

	@Override
	public User createUser(User u)
	{
		User u1=userrepository.save(u);
		return u1;
	}

	@Override
	public Customer signIn(int userId,String password)throws Exception 
	{
	   Supplier<Exception> s1 = ()->new ResourceNotFoundException("Invalid id & Password for SignIn");
	   Supplier<Exception> s2 = ()->new ResourceNotFoundException("The Entered UserId is Not Registered in Databse");
	   User u1=((Optional<User>) userrepository.SignIn(userId,password)).orElseThrow(s1);
	   Customer u2=((Optional<Customer>) userrepository.customer(userId)).orElseThrow(s2);
	   return u2;
	}

	
	@Override
	public User changeUserpassword(int userId,String password,String newpassword) throws Exception  
	{
		    String np=newpassword;
		    Supplier<Exception> s1 = ()->new ResourceNotFoundException("Provided Id and Password is not Valid");
		    User u1=((Optional<User>) userrepository.Changepassword(userId,password)).orElseThrow(s1);
		
		    u1.setPassword(np);
			userrepository.save(u1);
			return u1;	
	}

	
	@Override
	public User signOut(int userId) throws Exception 
	{
	   Supplier<Exception> s1 = ()->new ResourceNotFoundException("Invalid id for SignOut");
	   User u1=((Optional<User>) userrepository.SignOut(userId)).orElseThrow(s1);
	   return u1;
	}

}
	