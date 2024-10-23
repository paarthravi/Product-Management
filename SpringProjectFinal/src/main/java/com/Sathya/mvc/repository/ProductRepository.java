package com.Sathya.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sathya.mvc.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Long>{
	
}

