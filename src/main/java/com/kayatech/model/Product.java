package com.kayatech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "product_code")
	private String productCode;
	
	@Column(name = "product_title")
	private String productTitle;
	
	@Column(name = "product_price")
	private String productPrice;
	
	@Column(name = "product_test_link")
	private String productTestLink;
	
	@Column(name = "product_discount_code")
	private String productDiscountCode;
	
	@Column(name = "product_Tag")
	private String productTag;
	
	@Column(name = "product_owner")
	private String productOwner;

	@Column(name = "product_owner_email")
	private String productOwnerEmail;
	
	@Column(name = "product_description")
	private String productDescription;
	
	@Column(name = "product_header_image")
	private String productHeaderImage;
	
	@Column(name = "product_slider1")
	private String productSlider1;
	
	@Column(name = "product_slider2")
	private String productSlider2;
	
	@Column(name = "product_slider3")
	private String productSlider3;

	public Product() {}
	
	public Product(long id, String productCode, String productTitle, String productPrice, String productTestLink,
			String productDiscountCode, String productTag, String productOwner, String productOwnerEmail,
			String productDescription, String productHeaderImage, String productSlider1, String productSlider2,
			String productSlider3) {
		this.id = id;
		this.productCode = productCode;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productTestLink = productTestLink;
		this.productDiscountCode = productDiscountCode;
		this.productTag = productTag;
		this.productOwner = productOwner;
		this.productOwnerEmail = productOwnerEmail;
		this.productDescription = productDescription;
		this.productHeaderImage = productHeaderImage;
		this.productSlider1 = productSlider1;
		this.productSlider2 = productSlider2;
		this.productSlider3 = productSlider3;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductTestLink() {
		return productTestLink;
	}

	public void setProductTestLink(String productTestLink) {
		this.productTestLink = productTestLink;
	}

	public String getProductDiscountCode() {
		return productDiscountCode;
	}

	public void setProductDiscountCode(String productDiscountCode) {
		this.productDiscountCode = productDiscountCode;
	}

	public String getProductTag() {
		return productTag;
	}

	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}

	public String getProductOwner() {
		return productOwner;
	}

	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}

	public String getProductOwnerEmail() {
		return productOwnerEmail;
	}

	public void setProductOwnerEmail(String productOwnerEmail) {
		this.productOwnerEmail = productOwnerEmail;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductHeaderImage() {
		return productHeaderImage;
	}

	public void setProductHeaderImage(String productHeaderImage) {
		this.productHeaderImage = productHeaderImage;
	}

	public String getProductSlider1() {
		return productSlider1;
	}

	public void setProductSlider1(String productSlider1) {
		this.productSlider1 =productSlider1;
	}

	public String getProductSlider2() {
		return productSlider2;
	}

	public void setProductSlider2(String productSlider2) {
		this.productSlider2 =productSlider2;
	}

	public String getProductSlider3() {
		return productSlider3;
	}

	public void setProductSlider3(String productSlider3) {
		this.productSlider3 =productSlider3;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productCode=" + productCode + ", productTitle=" + productTitle
				+ ", productPrice=" + productPrice + ", productTestLink=" + productTestLink + ", productDiscountCode="
				+ productDiscountCode + ", productTag=" + productTag + ", productOwner=" + productOwner
				+ ", productOwnerEmail=" + productOwnerEmail + ", productDescription=" + productDescription
				+ ", productHeaderImage=" + productHeaderImage + ", productSlider1=" + productSlider1
				+ ", productSlider2=" + productSlider2 + ", productSlider3=" + productSlider3 + "]";
	}
	
	
	
	
	
	
	
}
