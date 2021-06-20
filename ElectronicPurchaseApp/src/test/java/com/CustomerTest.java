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

import com.entities.Address;
import com.entities.Customer;
import com.entities.ElectronicProduct;
import com.entities.ElectronicProductType;
import com.repository.CustomerRepository;
import com.service.CustomerService;

@SpringBootTest
class CustomerTest {

	
	@Autowired
	CustomerService customerService;
	
	@MockBean
	CustomerRepository customerRepo;
	
	
	  @Test void testshowAllCustomers() { 
	
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
			
			Address a = new Address();
			a.setAddressLineOne("shanker enclave");
			a.setCity("chennai");
			a.setCountry("India");
			a.setState("Tamil Nadu");
			
	  Customer c1= new Customer(1,"karthik","karthikkumar@gmai.com","8885552211",a,e1);
	  Customer c2=new Customer(2,"batra","batra@gmail.com","7766552244",a,e1);
	  
	  List<Customer> customerList = new ArrayList<>(); customerList.add(c1);
	  customerList.add(c2);
	  
	  Mockito.when(customerRepo.findAll()).thenReturn(customerList);
	  
	  assertThat(customerService.showAllCustomers()).isEqualTo(customerList);
	  
	  }
	 

	
	  @Test void testviewCustomer() {
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
			
			Address a = new Address();
			a.setAddressLineOne("shanker enclave");
			a.setCity("chennai");
			a.setCountry("India");
			a.setState("Tamil Nadu");
			
	  Customer c1= new Customer(1,"karthik","karthikkumar@gmai.com","8885552211",a,e1);
	  
	  Mockito.when(customerRepo.save(c1)).thenReturn(c1);
	  assertEquals(c1,customerService.addCustomer(c1));
	  
	  }
	  
	  @Test void testupdateCustomer() throws Exception { 
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
			
			Address a = new Address();
			a.setAddressLineOne("shanker enclave");
			a.setCity("chennai");
			a.setCountry("India");
			a.setState("Tamil Nadu");
			
	  Customer c1= new Customer(1,"karthik","karthikkumar@gmai.com","8885552211",a,e1);	  
	  
	  Optional<Customer> c2=Optional.of(c1);
		Mockito.when(customerRepo.findById(1)).thenReturn(c2);
		c1.setCustomerName("Shiva");
		
		
 Mockito.when(customerRepo.save(c1)).thenReturn(c1);
 assertThat(customerService.updateCustomer(c1)).isEqualTo(c1);
 
	  }
	  
	  @Test
		void testremoveCustomer() throws Exception{
			
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
			
			Address a = new Address();
			a.setAddressLineOne("shanker enclave");
			a.setCity("chennai");
			a.setCountry("India");
			a.setState("Tamil Nadu");
			
	  Customer c1= new Customer(1,"karthik","karthikkumar@gmai.com","8885552211",a,e1);	
			
			Optional<Customer> c2=Optional.of(c1);
			Mockito.when(customerRepo.findById(101)).thenReturn(c2);
			 Mockito.when(customerRepo.existsById(c1.getCustomerId())).thenReturn(false);
			   assertFalse(customerRepo.existsById(c1.getCustomerId()));
		}
	 
	  
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
				
				Address a = new Address();
				a.setAddressLineOne("shanker enclave");
				a.setCity("chennai");
				a.setCountry("India");
				a.setState("Tamil Nadu");
				
		  Customer c1= new Customer(1,"karthik","karthikkumar@gmai.com","8885552211",a,e1);	
			
	   Mockito.when(customerRepo.save(c1)).thenReturn(c1);
	   assertThat(customerService.addCustomer(c1)).isEqualTo(c1);
		}
		
}