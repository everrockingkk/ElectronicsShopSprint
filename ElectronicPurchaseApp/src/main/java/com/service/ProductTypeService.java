package com.service;

import java.util.List;

import com.entities.ElectronicProductType;

public interface ProductTypeService {
	public ElectronicProductType addProductType(ElectronicProductType ProductType);
	public ElectronicProductType updateProductType(ElectronicProductType ProductType) throws Exception;
	public ElectronicProductType removeProductType(int ProductTypeId) throws Exception;
	public List<ElectronicProductType> showAllProductTypes();

}
