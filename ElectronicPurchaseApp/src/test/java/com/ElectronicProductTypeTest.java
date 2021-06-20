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

import com.entities.ElectronicProductType;
import com.repository.ProductTypeRepository;
import com.service.ProductTypeServiceImpl;

@SpringBootTest
class ElectronicProductTypeTest {
	@MockBean
	ProductTypeRepository orepo;
	@Autowired
	ProductTypeServiceImpl oservice;
	

	@Test
	void testaddProductType() {
		ElectronicProductType e1=new ElectronicProductType();
         e1.setName("mobile");
         e1.setPrdTypeId(1);

		Mockito.when(orepo.save(e1)).thenReturn(e1);
		assertThat(oservice.addProductType(e1)).isEqualTo(e1);
	}
	
	@Test
	void testupdateProductType() throws Exception
	{
		ElectronicProductType e1=new ElectronicProductType();
        e1.setName("mobile");
        e1.setPrdTypeId(1);
		
		Optional<ElectronicProductType> e2=Optional.of(e1);
		Mockito.when(orepo.findById(1)).thenReturn(e2);
		e1.setName("laptop");
		Mockito.when(orepo.save(e1)).thenReturn(e1);
		assertThat(oservice.updateProductType(e1)).isEqualTo(e1);
	}
	
	@Test
	void testremoveProductType() throws Exception
	{
		ElectronicProductType e1=new ElectronicProductType();
        e1.setName("mobile");
        e1.setPrdTypeId(1);
		Optional<ElectronicProductType> e2=Optional.of(e1);
		Mockito.when(orepo.findById(1)).thenReturn(e2);
		Mockito.when(orepo.existsById(e1.getPrdTypeId())).thenReturn(false);
		assertFalse(orepo.existsById(e1.getPrdTypeId()));
		
		
	}
	
	
	@Test
	void testshowAllProductTypes()
	{
		ElectronicProductType e1=new ElectronicProductType();
        e1.setName("mobile");
        e1.setPrdTypeId(1);
		
		
        ElectronicProductType e2=new ElectronicProductType();
        e1.setName("laptop");
        e1.setPrdTypeId(2);
		
		List<ElectronicProductType> list=new ArrayList<>();
	     list.add(e1);
	     list.add(e2);
		Mockito.when(orepo.findAll()).thenReturn(list);
		assertThat(oservice.showAllProductTypes()).isEqualTo(list);
		}
	
	
}