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

import com.entities.ElectronicProductOrder;
import com.service.ElectronicProductOrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ElectronicProductOrderController {
	@Autowired
	private ElectronicProductOrderService orderService;

	@PostMapping(path="/addOrder")
	public ResponseEntity<ElectronicProductOrder> addProductOrder(@Valid @RequestBody ElectronicProductOrder productOrder){
		ElectronicProductOrder ep=orderService.addProductOrder(productOrder);
		ResponseEntity<ElectronicProductOrder> re=new ResponseEntity<ElectronicProductOrder>(ep,HttpStatus.OK);
		return re;
	}

	@GetMapping("/getOrders")
	public List<ElectronicProductOrder> showAllCustomers()
	{ 
		return this.orderService.showAllOrders();
	}
	@GetMapping("/getOrder/{orderId}")
	public Optional<ElectronicProductOrder> viewProductOrder(@PathVariable int orderId) throws Exception
	{
		
		return this.orderService.viewProductOrder(orderId);
	}
	@PutMapping(path="/updateOrder")
	public ResponseEntity<ElectronicProductOrder> updateProductOrder(@Valid @RequestBody ElectronicProductOrder productOrder) throws Exception
	{
			ElectronicProductOrder e= this.orderService.updateProductOrder(productOrder);
			ResponseEntity re= new ResponseEntity<ElectronicProductOrder>(e,HttpStatus.OK);
			return re;
		
	}
	
	@DeleteMapping(path="/removeOrder/{orderId}")
	public ResponseEntity<ElectronicProductOrder> removeProductOrder(@PathVariable int orderId) throws Exception{
		ElectronicProductOrder e=orderService.removeProductOrder(orderId);
		ResponseEntity<ElectronicProductOrder> re=new ResponseEntity<ElectronicProductOrder>(e,HttpStatus.OK);
		return re;
	}
	
	

}
