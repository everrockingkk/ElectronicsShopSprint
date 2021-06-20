package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.entities.ElectronicProductOrder;


@Service
public interface ElectronicProductOrderService {
	 ElectronicProductOrder addProductOrder(ElectronicProductOrder productOrder);
	 ElectronicProductOrder updateProductOrder(ElectronicProductOrder productOrder) throws Exception;
	 ElectronicProductOrder removeProductOrder(int productOrderId) throws Exception;
	 List<ElectronicProductOrder> showAllOrders();
	 Optional<ElectronicProductOrder> viewProductOrder(int productOrderId) throws Exception;

}
