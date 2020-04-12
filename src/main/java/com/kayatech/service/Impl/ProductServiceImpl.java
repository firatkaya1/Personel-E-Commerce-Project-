package com.kayatech.service.Impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kayatech.model.Product;
import com.kayatech.repository.ProductRepository;
import com.kayatech.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final String UPLOAD_DIR = "/home/choose/eclipse-workspace/eco.zip_expanded/eco/src/main/resources/static/uploadImages";
	private static final String FOLDER = "/uploadImages/";
	
	
	@Autowired
	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	@Override
	public void uploadFile(List<MultipartFile>  f) {
		for (MultipartFile file : f) {
			   try {
			   	 Path copyLocation = Paths.get(UPLOAD_DIR + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
			   	Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);          
			   } catch (Exception e) {
			       e.printStackTrace();
			   }
			}
	}

	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		
		Product p = new Product();
		
		p.setProductCode(product.getProductCode());
		p.setProductTitle(product.getProductTitle());
		p.setProductPrice(product.getProductPrice());
		p.setProductTestLink(product.getProductTestLink());
		p.setProductDiscountCode(product.getProductDiscountCode());
		p.setProductTag(product.getProductTag());
		p.setProductOwner(product.getProductOwner());
		p.setProductOwnerEmail(product.getProductOwnerEmail());
		p.setProductDescription(product.getProductDescription());
		p.setProductHeaderImage(FOLDER + product.getProductHeaderImage());
		p.setProductSlider1(FOLDER +product.getProductSlider1());
		p.setProductSlider2(FOLDER +product.getProductSlider2());
		p.setProductSlider3(FOLDER +product.getProductSlider3());
		
		return productRepository.save(p);
	}
	

	@Override
	public Product uptadeProduct(Product product) {
		
		Product p = new Product();
		
		p.setId(product.getId());
		p.setProductCode(product.getProductCode());
		p.setProductTitle(product.getProductTitle());
		p.setProductPrice(product.getProductPrice());
		p.setProductTestLink(product.getProductTestLink());
		p.setProductDiscountCode(product.getProductDiscountCode());
		p.setProductTag(product.getProductTag());
		p.setProductOwner(product.getProductOwner());
		p.setProductOwnerEmail(product.getProductOwnerEmail());
		p.setProductDescription(product.getProductDescription());
		p.setProductHeaderImage(FOLDER + product.getProductHeaderImage());
		p.setProductSlider1(FOLDER +product.getProductSlider1());
		p.setProductSlider2(FOLDER +product.getProductSlider2());
		p.setProductSlider3(FOLDER +product.getProductSlider3());
		
		
		return productRepository.save(p);
	}

	
	@Override
	public Boolean deleteProduct(String productCode) {
		
		if(productRepository.findByProductCode(productCode).getProductCode().equals(productCode)) {
			productRepository.delete(productRepository.findByProductCode(productCode));
			return true;
		}
		return false;
	}

	@Override
	public Product findByProductCode(String productCode) {
		
		return productRepository.findByProductCode(productCode);
	}

	@Override
	public List<Product> findByProductTag(String productTag) {
		return productRepository.findByProductTag(productTag);
	}


	@Override
	public List<String> findAllTags() {
		return productRepository.findAllTag();
	}





































}
