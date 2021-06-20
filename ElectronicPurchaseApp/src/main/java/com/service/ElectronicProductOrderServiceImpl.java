package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.ElectronicProductOrder;
import com.error.ResourceNotFoundException;
import com.repository.ElectronicProductOrderRepository;

@Service
public class ElectronicProductOrderServiceImpl implements ElectronicProductOrderService {

	@Autowired
	private ElectronicProductOrderRepository electronicProductOrderRepo;

	@Override
	public ElectronicProductOrder addProductOrder(ElectronicProductOrder productOrder) {
		ElectronicProductOrder e= electronicProductOrderRepo.save(productOrder);
		return e;
		
	}

	@Override
	public ElectronicProductOrder updateProductOrder(ElectronicProductOrder productOrder) throws Exception {
		int id=productOrder.getOrderId();
		Supplier<Exception> s1=()-> new ResourceNotFoundException("No Customer found with id"+id);
		ElectronicProductOrder e1=electronicProductOrderRepo.findById(id).orElseThrow(s1);;
		e1.setOrderId(productOrder.getOrderId());
		e1.setOrderDate(productOrder.getOrderDate());
		e1.setOrderStatus(productOrder.getOrderStatus());
		e1.setTotalAmount(productOrder.getTotalAmount());
		e1.setCustomer(productOrder.getCustomer());
		
		electronicProductOrderRepo.save(productOrder);
		return e1;
		
	}

	@Override
	public ElectronicProductOrder removeProductOrder(int productOrderId)
			throws Exception {
		Supplier<Exception> s1=()-> new ResourceNotFoundException("No Customer found with id "+productOrderId);
		ElectronicProductOrder e1=electronicProductOrderRepo.findById(productOrderId).orElseThrow(s1);
		electronicProductOrderRepo.delete(e1);
		return e1;
	
	}

	@Override
	public List<ElectronicProductOrder> showAllOrders() {
		return electronicProductOrderRepo.findAll();
	}



	@Override
	public Optional<ElectronicProductOrder> viewProductOrder(int productOrderId)
			throws Exception {
		return electronicProductOrderRepo.findById(productOrderId);
		
	}

}
