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
import com.entities.ElectronicProductOrder;
import com.repository.ElectronicProductOrderRepository;
import com.service.ElectronicProductOrderServiceImpl;

@SpringBootTest
class ElectronicProductOrderTest {
	@MockBean
	ElectronicProductOrderRepository orepo;
	
	@Autowired
	ElectronicProductOrderServiceImpl oservice;
	
	

	
	

	@Test
	void testaddProductOrder() {
		
		Address a = new Address();
		a.setAddressLineOne("shanker enclave");
		a.setCity("chennai");
		a.setCountry("India");
		a.setState("Tamil Nadu");
		
		
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setCustomerName("karthik");
		c.setCustomerPhone("9998885522");
		c.setCustomerEmail("Rakesh123@gmail.com");
		c.setCustomerAddress(a);
		c.setProductList(null);
		
		ElectronicProductOrder e1=new ElectronicProductOrder();
		e1.setOrderDate("2021-06-18");
		e1.setOrderId(1);
		e1.setOrderStatus("ok");
		e1.setTotalAmount(2000);
		e1.setCustomer(c);
		
		Mockito.when(orepo.save(e1)).thenReturn(e1);
		assertThat(oservice.addProductOrder(e1)).isEqualTo(e1);
		//fail("Not yet implemented");
	}
	
	@Test
	void testupdateProductOrder() throws Exception
	{
		Address a = new Address();
		a.setAddressLineOne("shanker enclave");
		a.setCity("chennai");
		a.setCountry("India");
		a.setState("Tamil Nadu");
		
		
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setCustomerName("karthik");
		c.setCustomerPhone("9998885522");
		c.setCustomerEmail("Rakesh123@gmail.com");
		c.setCustomerAddress(a);
		c.setProductList(null);
		
		ElectronicProductOrder e1=new ElectronicProductOrder();
		e1.setOrderDate("2021-06-18");
		e1.setOrderId(1);
		e1.setOrderStatus("ok");
		e1.setTotalAmount(2000);
		e1.setCustomer(c);
		
		Optional<ElectronicProductOrder> e2=Optional.of(e1);
		Mockito.when(orepo.findById(1)).thenReturn(e2);
		e1.setOrderStatus("failed");
		Mockito.when(orepo.save(e1)).thenReturn(e1);
		assertThat(oservice.updateProductOrder(e1)).isEqualTo(e1);
	}
	
	@Test
	void testremoveProductOrder() throws Exception
	{
		Address a = new Address();
		a.setAddressLineOne("shanker enclave");
		a.setCity("chennai");
		a.setCountry("India");
		a.setState("Tamil Nadu");
		
		
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setCustomerName("karthik");
		c.setCustomerPhone("9998885522");
		c.setCustomerEmail("Rakesh123@gmail.com");
		c.setCustomerAddress(a);
		c.setProductList(null);
		
		ElectronicProductOrder e1=new ElectronicProductOrder();
		e1.setOrderDate("2021-06-18");
		e1.setOrderId(1);
		e1.setOrderStatus("ok");
		e1.setTotalAmount(2000);
		e1.setCustomer(c);
		
		
		Optional<ElectronicProductOrder> e2=Optional.of(e1);
		Mockito.when(orepo.findById(1)).thenReturn(e2);
		Mockito.when(orepo.existsById(e1.getOrderId())).thenReturn(false);
		assertFalse(orepo.existsById(e1.getOrderId()));
		
		
	}
	
	
	@Test
	void testshowAllOrders()
	{
		Address a = new Address();
		a.setAddressLineOne("shanker enclave");
		a.setCity("chennai");
		a.setCountry("India");
		a.setState("Tamil Nadu");
		
		
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setCustomerName("karthik");
		c.setCustomerPhone("9998885522");
		c.setCustomerEmail("Rakesh123@gmail.com");
		c.setCustomerAddress(a);
		c.setProductList(null);
		
		ElectronicProductOrder e1=new ElectronicProductOrder();
		e1.setOrderDate(null);
		e1.setOrderId(1);
		e1.setOrderStatus("ok");
		e1.setTotalAmount(2000);
		e1.setCustomer(c);
		
		
		ElectronicProductOrder e2=new ElectronicProductOrder();
		e2.setOrderDate("2021-06-18");
		e2.setOrderId(2);
		e2.setOrderStatus("confirm");
		e2.setTotalAmount(4000);
		e1.setCustomer(c);
		
		List<ElectronicProductOrder> list=new ArrayList<>();
		list.add(e1);
		list.add(e2);
		
		Mockito.when(orepo.findAll()).thenReturn(list);
		assertThat(oservice.showAllOrders()).isEqualTo(list);	
	}
	
	@Test
	void testElectronicProductOrder() throws Exception
	{
		Address a = new Address();
		a.setAddressLineOne("shanker enclave");
		a.setCity("chennai");
		a.setCountry("India");
		a.setState("Tamil Nadu");
		
		
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setCustomerName("karthik");
		c.setCustomerPhone("9998885522");
		c.setCustomerEmail("Rakesh123@gmail.com");
		c.setCustomerAddress(a);
		c.setProductList(null);
		
		ElectronicProductOrder e1=new ElectronicProductOrder();
		e1.setOrderDate("2021-06-18");
		e1.setOrderId(1);
		e1.setOrderStatus("ok");
		e1.setTotalAmount(2000);
		e1.setCustomer(c);
		
	
	Optional<ElectronicProductOrder> e2=Optional.of(e1);
	Mockito.when(orepo.findById(1)).thenReturn(e2);
	assertThat(oservice.viewProductOrder(1)).isEqualTo(e2);
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
