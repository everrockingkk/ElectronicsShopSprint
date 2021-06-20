package com.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.ElectronicProductOrder;

@Repository
public interface ElectronicProductOrderRepository extends JpaRepository<ElectronicProductOrder, Integer>{

	
}

	
