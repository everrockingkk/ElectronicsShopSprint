package com.controller;

import java.util.List;

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

import com.entities.ElectronicProductType;
import com.service.ProductTypeServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductTypeController {
	
	@Autowired
	private ProductTypeServiceImpl productservice;
	
	@PostMapping(path="/addProducttype")
	public ResponseEntity<ElectronicProductType> addProduct(@Valid@RequestBody ElectronicProductType product){
		ElectronicProductType ep=productservice.addProductType(product);
		ResponseEntity res=new ResponseEntity<ElectronicProductType>(ep,HttpStatus.OK);
		return res;
	}
	
	@PutMapping(path="/updatetype")
	public ResponseEntity<ElectronicProductType>updatetype(@Valid@RequestBody  ElectronicProductType product) throws Exception {
		ElectronicProductType ep=productservice.updateProductType(product);
		ResponseEntity re=new ResponseEntity<ElectronicProductType>(ep,HttpStatus.OK);
		return re;	
	}
	
	
	@DeleteMapping(path="/removeProducttype/{pid}")
	public ElectronicProductType removeProducttype(@PathVariable("pid") int productId) throws Exception {
		 return productservice.removeProductType(productId);
				
	}
	
	@GetMapping(path="/showAllProductstype")
	public ResponseEntity<ElectronicProductType> showAllProductsType(){
		List<ElectronicProductType> le=productservice.showAllProductTypes();
		ResponseEntity re=new ResponseEntity<List<ElectronicProductType>>(le,HttpStatus.OK);
		return re;	
	}

}
