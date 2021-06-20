package com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.ElectronicProduct;
import com.entities.ElectronicProductType;
import com.repository.ElectronicProductRepository;
import com.service.ElectronicProductServiceImpl;
@SpringBootTest
class ElectronicProductTest {
	@Autowired
	ElectronicProductServiceImpl epservice;
	
	@MockBean
	ElectronicProductRepository eprepo;

	
	
	@Test
	void testaddProduct() {
		
		ElectronicProductType ept= new ElectronicProductType();
		ept.setPrdTypeId(122);
		ept.setName("shiva");
		
		
		ElectronicProduct e1=new ElectronicProduct();
		e1.setCode(101);
		e1.setName("Mobile");
		e1.setPrice(45000.00);
		e1.setImage("F:/images.samsung.jpeg");
		e1.setCreateDate("19-07-2021");
		e1.setProductType(ept);
		
   Mockito.when(eprepo.save(e1)).thenReturn(e1);
   assertThat(epservice.addProduct(e1)).isEqualTo(e1);
	}
	
	
	@Test
	void testupdateProduct() throws Exception {
		ElectronicProductType ept= new ElectronicProductType();
		ept.setPrdTypeId(122);
		ept.setName("shiva");
		
		ElectronicProduct e1=new ElectronicProduct();
		e1.setCode(101);
		e1.setName("Mobile");
		e1.setPrice(45000.00);
		e1.setImage("F:/images.samsung.jpeg");
		e1.setCreateDate("19-07-2021");
		e1.setProductType(ept);
		
		Optional<ElectronicProduct> e2=Optional.of(e1);
		Mockito.when(eprepo.findById(101)).thenReturn(e2);
		e1.setName("SmartPhone");
		
		
   Mockito.when(eprepo.save(e1)).thenReturn(e1);
   assertThat(epservice.updateProduct(e1)).isEqualTo(e1);
	}
	
	@Test
	void testremoveProduct() throws Exception{
		
		ElectronicProductType ept= new ElectronicProductType();
		ept.setPrdTypeId(122);
		ept.setName("shiva");
		
		ElectronicProduct e1=new ElectronicProduct();
		e1.setCode(101);
		e1.setName("Mobile");
		e1.setPrice(45000.00);
		e1.setImage("F:/images.samsung.jpeg");
		e1.setCreateDate("19-07-2021");
		e1.setProductType(ept);
		
		Optional<ElectronicProduct> e2=Optional.of(e1);
		Mockito.when(eprepo.findById(101)).thenReturn(e2);
		 Mockito.when(eprepo.existsById(e1.getCode())).thenReturn(false);
		   assertFalse(eprepo.existsById(e1.getCode()));
	}
	@Test
	void testshowAllProducts() {
		ElectronicProductType ept= new ElectronicProductType();
		ept.setPrdTypeId(122);
		ept.setName("shiva");
		
		ElectronicProduct e1=new ElectronicProduct();
		e1.setCode(101);
		e1.setName("Mobile");
		e1.setPrice(45000.00);
		e1.setImage("F:/images.samsung.jpeg");
		e1.setCreateDate("19-07-2021");
		e1.setProductType(ept);
		
		ElectronicProduct e2=new ElectronicProduct();
		e1.setCode(102);
		e1.setName("Iphone");
		e1.setPrice(45000.00);
		e1.setImage("F:/images.apple.jpeg");
		e1.setCreateDate("19-07-2021");
		e1.setProductType(ept);
		
		List<ElectronicProduct> epList = new ArrayList<>();
		epList.add(e1);
		epList.add(e2);
		
		Mockito.when(eprepo.findAll()).thenReturn(epList);
		
		assertThat(epservice.showAllProducts()).isEqualTo(epList);
		
	}
	@Test
	void testviewProduct() {
		
		ElectronicProductType ept= new ElectronicProductType();
		ept.setPrdTypeId(122);
		ept.setName("shiva");
		
		ElectronicProduct e1=new ElectronicProduct();
		e1.setCode(101);
		e1.setName("Mobile");
		e1.setPrice(45000.00);
		e1.setImage("F:/images.samsung.jpeg");
		e1.setCreateDate("19-07-2021");
		e1.setProductType(ept);
		
		Optional<ElectronicProduct> e2=Optional.of(e1);
   Mockito.when(eprepo.findById(101)).thenReturn(e2);
   assertThat(epservice.viewProduct(101)).isEqualTo(e2);
	}

	

}
