package com;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.Address;
import com.entities.Customer;
import com.entities.User;
import com.repository.UserRepository;
import com.service.UserService;

@SpringBootTest
class UserTest {

	@Autowired
	UserService userservice;
	
	@MockBean
	UserRepository userrepository;
	
	@Test
	void testcreateUser()
	{
		User user1 = new User();
		user1.setUserId(110);
		user1.setRole("Admin");
		user1.setPassword("Shiva@123");
		
		Mockito.when(userrepository.save(user1)).thenReturn(user1);
		
		User response=userservice.createUser(user1);
		
		assertThat(response.getUserId()).isEqualTo(110);
		assertThat(response.getPassword()).isEqualTo("Shiva@123");
		assertThat(response.getRole()).isEqualTo("Admin");
	}
	
	@Test
	void testChangeUserpassword() throws Exception 
	{
		User user1 = new User();
		user1.setUserId(110);
		user1.setRole("Admin");
		user1.setPassword("Shiva@123");
		
		Optional<User> user2=Optional.of(user1);
		
		Mockito.when(userrepository.Changepassword( 110, "Shiva@123" )).thenReturn(user2);
		user1.setPassword("Ven@5555");
		Mockito.when(userrepository.save(user1)).thenReturn(user1);	
		assertThat(userservice.changeUserpassword(110,"Shiva@123","shiv@555")).isEqualTo(user1);	
	}	
	
	@Test
	void testSignOut() throws Exception 
	{
		User user1 = new User();
		user1.setUserId(110);
		user1.setPassword("Rakesh@123");
		user1.setRole("Customer");
		Optional<User> u2 = Optional.of(user1);
		Mockito.when(userrepository.SignOut(110)).thenReturn(u2);
		Optional<User> u3 = Optional.of(userservice.signOut(110));
		assertThat(u3).isEqualTo(u2);	
		
	}
	
	
	@Test 
	void testSignIn() throws Exception 
	{
		User u1 = new User();
		u1.setUserId(110);
		u1.setPassword("Rakesh@123");
		u1.setRole("Customer");
		Optional<User> u2 = Optional.of(u1);
		
		Address a = new Address();
		a.setAddressLineOne("shanker enclave");
		a.setCity("chennai");
		a.setCountry("India");
		a.setState("Tamil Nadu");
		
		
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setCustomerName("karthik");
		c.setCustomerPhone("9998885522");
		c.setCustomerEmail("Rakesh123@gmail.com");
		c.setCustomerAddress(a);
		c.setProductList(null);
		
		Optional<Customer> c2 = Optional.of(c);
		
		Mockito.when(userrepository.SignIn(110,"Rakesh@123")).thenReturn(u2);
		Mockito.when(userrepository.customer(110)).thenReturn(c2);
		Optional<Customer> c3=Optional.of(userservice.signIn(110,"Rakesh@123"));	
		assertThat(c3).isEqualTo(c2);
	}
}
