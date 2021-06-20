package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class ElectronicProductType {
	@Id
	private int prdTypeId;
	
	@NotNull
	private String name;
	
	
	public ElectronicProductType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElectronicProductType(int prdTypeId,@NotNull String name) {
		super();
		this.prdTypeId = prdTypeId;
		this.name = name;
	}
	
	public int getPrdTypeId() {
		return prdTypeId;
	}
	public void setPrdTypeId(int prdTypeId) {
		this.prdTypeId = prdTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ElectronicProductType [prdTypeId=" + prdTypeId + ", name=" + name + "]";
	}
	
	
	
}
