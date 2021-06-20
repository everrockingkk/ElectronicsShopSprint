package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Customer;
import com.error.ResourceNotFoundException;
import com.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;

	
	@Override
	public Customer addCustomer(Customer customer) {
		Customer m= customerRepository.save(customer);
		return m;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws Exception {
		int id=customer.getCustomerId();
		Supplier<Exception> s1=()-> new ResourceNotFoundException("No Customer found with id"+id);
		Customer c1=customerRepository.findById(id).orElseThrow(s1);
		c1.setCustomerId(customer.getCustomerId());
		c1.setCustomerEmail(customer.getCustomerEmail());
		c1.setCustomerName(customer.getCustomerName());
		c1.setCustomerPhone(customer.getCustomerPhone());
		c1.setCustomerAddress(customer.getCustomerAddress());
		c1.setProductList(customer.getProductList());
		
		customerRepository.save(customer);
		return c1;
	}

	@Override
	public Customer removeCustomer(int customerId) throws Exception {
		Supplier<Exception> s1=()-> new ResourceNotFoundException("No Customer found with id"+customerId);
		Customer c1=customerRepository.findById(customerId).orElseThrow(s1);
		customerRepository.delete(c1);
		return c1;
	}

	@Override
	public List<Customer> showAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> viewCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}



}
