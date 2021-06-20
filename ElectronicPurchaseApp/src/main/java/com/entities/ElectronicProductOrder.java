package com.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
public class ElectronicProductOrder {
	@Id
	@GeneratedValue
	private  int orderId;
	
	@NotNull
	@Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$",message="Provide Date in the format DD-MM-YYYY")
	private String orderDate;
    
    @NotNull
    @OneToOne(cascade=CascadeType.ALL)
    private Customer customer;
    

	
    @NotNull
    private double totalAmount;	

    @NotNull
	private String orderStatus;

	public ElectronicProductOrder() {
		super();
	}

	public ElectronicProductOrder(int orderId,@NotNull @Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$",message="Provide Date in the format DD-MM-YYYY") String orderDate,@NotNull Customer customer,
			@NotNull double totalAmount,@NotNull String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customer = customer;
		
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "ElectronicProductOrder [orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer
				+ ", totalAmount=" + totalAmount + ", orderStatus=" + orderStatus + "]";
	}
	
	
	
	
	
	
	
	
	

}
