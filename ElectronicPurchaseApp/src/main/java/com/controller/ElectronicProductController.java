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

import com.entities.ElectronicProduct;
import com.service.ElectronicProductServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ElectronicProductController {
	
	@Autowired
	private ElectronicProductServiceImpl electronicProductService;
	
	@PostMapping(path="/addProduct")
	public ResponseEntity<ElectronicProduct> addElectronicProduct(@Valid@RequestBody ElectronicProduct product){
		ElectronicProduct ep=electronicProductService.addProduct(product);
		ResponseEntity re=new ResponseEntity<ElectronicProduct>(ep,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<ElectronicProduct>update(@Valid @RequestBody  ElectronicProduct product) throws Exception {
		ElectronicProduct ep=electronicProductService.updateProduct(product);
		ResponseEntity re=new ResponseEntity<ElectronicProduct>(ep,HttpStatus.OK);
		return re;	
	}
	
	@DeleteMapping(path="/removeProduct/{pid}")
	public ElectronicProduct removeProduct(@PathVariable("pid") int productId) throws Exception {
		 return electronicProductService.removeProduct(productId);
				
	}
	
	@GetMapping(path="/showAllProducts")
	public ResponseEntity<ElectronicProduct> showAllProducts(){
		List<ElectronicProduct> le=electronicProductService.showAllProducts();
		ResponseEntity re=new ResponseEntity<List<ElectronicProduct>>(le,HttpStatus.OK);
		return re;	
	}
	
	@GetMapping(path="/viewProduct/{code}")
	public ElectronicProduct viewProduct(@PathVariable int code) {
		Optional<ElectronicProduct> product=electronicProductService.viewProduct(code);
		return product.get();
	}
	@GetMapping(path="/getProductName")
	public ResponseEntity<List<ElectronicProduct>>getProductbyName( String name)
	{
		List<ElectronicProduct> le=electronicProductService.showProductListByName(name);
		ResponseEntity re=new ResponseEntity<List<ElectronicProduct>>(le,HttpStatus.OK);
		return re;
		
	}
		

}
