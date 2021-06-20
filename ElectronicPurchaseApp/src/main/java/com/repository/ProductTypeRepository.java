package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.ElectronicProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ElectronicProductType,Integer>{

}
