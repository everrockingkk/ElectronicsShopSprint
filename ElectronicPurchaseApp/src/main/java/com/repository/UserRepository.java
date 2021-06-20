package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Customer;
import com.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	@Query("Select u from User u where u.userId=?1 and u.password=?2")
	Optional<User> SignIn(int userId,String password);
	
	@Query("Select c from Customer c Where customerId=?1")
	Optional<Customer> customer(int userId);
	
	@Query("Select u from User u where u.userId=?1")
	Optional<User> SignOut(int userId);
	
	@Query("Select u from User u where u.userId=?1 and u.password=?2")
	Optional<User> Changepassword(int userId,String password);

	
}
