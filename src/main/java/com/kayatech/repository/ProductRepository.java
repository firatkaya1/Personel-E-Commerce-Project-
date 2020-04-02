package com.kayatech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kayatech.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public static final String FIND_PROJECTS = "SELECT product_code FROM products";


	Product findByProductCode(String productCode);
	
	List<Product> findByProductTag(String productTag);
	
	List<Product> findAll();
	
	@Query(value = FIND_PROJECTS, nativeQuery = true)
	List<String> findAllTag();
	
	
	
}
