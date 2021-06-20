package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private int aId;
	
	@NotNull
	private String addressLineOne;
	
	@NotNull
	private String city;
	
	@NotNull
	private String state;
	
	@NotNull
	private String country;
	
	@NotNull
	@Size(min=6, max=6)
	private String postalCode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int aId,@NotNull String addressLineOne,@NotNull String city,@NotNull String state,@NotNull String country,@NotNull@Size(min=6, max=6) String postalCode) {
		super();
		this.aId = aId;
		this.addressLineOne = addressLineOne;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}


	@Override
	public String toString() {
		return "Address [addressLineOne=" + addressLineOne + ", city=" + city + ", state=" + state + ", country="
				+ country + ", postalCode=" + postalCode + "]";
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}
	
	

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
	
}
