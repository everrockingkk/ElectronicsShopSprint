package com.entities;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;

@Entity
public class Customer {
	
	@Id
	private int customerId;
	
	@NotEmpty(message="Please enter Name ")
	private String customerName;
	
	@NotEmpty(message="Please enter valid Email")
	@Email
	private String customerEmail;
	
	@NotEmpty(message="Please enter PhoneNumber")
	@Size(min=10,max=10)
	private String customerPhone;
	
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	private Address customerAddress;
	 
	
	//@NotNull  
	@OneToOne(cascade=CascadeType.ALL)
	private ElectronicProduct productList;
	 
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int customerId,@NotEmpty(message="Please enter Name ") String customerName,@NotEmpty(message="Please enter valid Email") String customerEmail,@NotEmpty(message="Please enter PhoneNumber") String customerPhone,
			@NotNull Address customerAddress,@NotNull ElectronicProduct productList) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.productList = productList;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public Address getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}


	public ElectronicProduct getProductList() {
		return productList;
	}


	public void setProductList(ElectronicProduct productList) {
		this.productList = productList;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPhone=" + customerPhone + ", customerAddress=" + customerAddress
				+ ", productList=" + productList + "]";
	}







	

	 

	
	
	
	
}
