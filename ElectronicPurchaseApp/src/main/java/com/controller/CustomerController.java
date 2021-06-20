package com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Customer;
import com.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;

	@PostMapping(path="/addCustomer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){
		Customer ep=customerService.addCustomer(customer);
		ResponseEntity<Customer> re=new ResponseEntity<Customer>(ep,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCustomers")
	public List<Customer> showAllCustomers()
	{ return this.customerService.showAllCustomers(); }
	
	
	@GetMapping("/getCustomer/{cId}")
	public Optional<Customer> viewCustomer(@PathVariable int cId)
	{
		
		return this.customerService.viewCustomer(cId);
	}
	
	@PutMapping(path="/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) throws Exception
	{
			Customer c= this.customerService.updateCustomer(customer);
			ResponseEntity re= new ResponseEntity<Customer>(c,HttpStatus.OK);
			return re;
		
	}
	
	@DeleteMapping(path="/removeCustomer/{cId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable int cId) throws Exception{
		Customer c=customerService.removeCustomer(cId);
		ResponseEntity<Customer> re=new ResponseEntity<Customer>(c,HttpStatus.OK);
		return re;
	}
	
	
}
