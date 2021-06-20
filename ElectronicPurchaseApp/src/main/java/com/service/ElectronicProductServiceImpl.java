package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.ElectronicProduct;
import com.error.ResourceNotFoundException;
import com.repository.ElectronicProductRepository;

@Service
public class ElectronicProductServiceImpl implements ElectronicProductService {
	
	List<ElectronicProduct> lep;
	
	@Autowired
	private ElectronicProductRepository electronicproductrepo;

	@Override
	public ElectronicProduct addProduct(ElectronicProduct product) {
		ElectronicProduct ep=electronicproductrepo.save(product);
		return ep;
	}

	@Override
	public ElectronicProduct updateProduct(ElectronicProduct product)throws Exception {		
		int id=product.getCode();
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("no such product to update"+id);
		ElectronicProduct e1=electronicproductrepo.findById(id).orElseThrow(s1);
		e1.setCode(product.getCode());
		e1.setName(product.getName());
		e1.setPrice(product.getPrice());
		e1.setImage(product.getImage());
		e1.setCreateDate(product.getCreateDate());
		e1.setProductType(product.getProductType());
		
		electronicproductrepo.save(e1);
		return e1;
		
	}
	@Override
	public ElectronicProduct removeProduct(int productId) throws Exception {
		Optional<ElectronicProduct> electronicProduct=electronicproductrepo.findById(productId);
		
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("no such product to Delete");
		ElectronicProduct e1=electronicproductrepo.findById(productId).orElseThrow(s1);
		
		ElectronicProduct electronicProduct1=null;
		if(electronicProduct.isPresent()) {
			electronicProduct1=electronicProduct.get();
			electronicproductrepo.deleteById(productId);
			
		}
		return electronicProduct1;	
	}
		

	@Override
	public List<ElectronicProduct> showAllProducts() {
		lep=new ArrayList<>();
		lep=electronicproductrepo.findAll();
		return lep;
	}

	@Override
	public Optional<ElectronicProduct> viewProduct(int code) {
		Optional<ElectronicProduct> product=electronicproductrepo.findById(code);
		return product;
		
	}
	 

	@Override
	public List<ElectronicProduct>showProductListByName(String name) {
		List<ElectronicProduct> ls=electronicproductrepo.findByNameSorted(name);
		return ls;
		
		// TODO Auto-generated method stub
		
	}

	

	
}
