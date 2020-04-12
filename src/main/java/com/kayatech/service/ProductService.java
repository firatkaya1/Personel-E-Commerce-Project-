package com.kayatech.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kayatech.model.Product;

@Service
public interface ProductService {

	public void uploadFile(List<MultipartFile>  f);
	
	List<Product> getAllProducts();
	
	Product addProduct(Product product);
	

	Product uptadeProduct(Product product);
	
	Boolean deleteProduct(String productCode);
	
	Product findByProductCode(String productCode);
	
	List<Product> findByProductTag(String productTag);
	
	
	List<String> findAllTags();

}