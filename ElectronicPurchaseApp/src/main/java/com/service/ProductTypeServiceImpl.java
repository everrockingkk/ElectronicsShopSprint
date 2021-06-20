package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.ElectronicProductType;
import com.error.ResourceNotFoundException;
import com.repository.ProductTypeRepository;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{
	
    List<ElectronicProductType> producttype;
	
	@Autowired
	private ProductTypeRepository productrepo;


	@Override
	public ElectronicProductType addProductType(ElectronicProductType ProductType) {
		ElectronicProductType ep=productrepo.save(ProductType);
		return ep;
	}

	@Override
	public ElectronicProductType updateProductType(ElectronicProductType ProductType)throws Exception {
		int id=ProductType.getPrdTypeId();
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("product type is not avilable to update"+id);
		ElectronicProductType e1=productrepo.findById(id).orElseThrow(s1);
		e1.setPrdTypeId(ProductType.getPrdTypeId());
		e1.setName(ProductType.getName());
		productrepo.save(e1);
		return e1;
	}

	@Override
	public ElectronicProductType removeProductType(int ProductTypeId) throws Exception {
    Optional<ElectronicProductType> electronicProduct=productrepo.findById(ProductTypeId);
		
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("product type is not avilable to Delete");
		ElectronicProductType e1=productrepo.findById(ProductTypeId).orElseThrow(s1);
		
		ElectronicProductType electronicProduct1=null;
		if(electronicProduct.isPresent()) {
			electronicProduct1=electronicProduct.get();
			productrepo.deleteById(ProductTypeId);
			
		}
		return electronicProduct1;
	}

	@Override
	public List<ElectronicProductType> showAllProductTypes() {
		producttype=new ArrayList<>();
		producttype=productrepo.findAll();
		return producttype;
	}

}
