package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entities.Customer;


@Service
public interface CustomerService {
	public Customer addCustomer(Customer c);
	public Customer updateCustomer(Customer customer) throws Exception;
	public Customer removeCustomer(int customerId) throws Exception;
	public List<Customer> showAllCustomers();
	public Optional<Customer> viewCustomer(int customerdId);
	
	
}
