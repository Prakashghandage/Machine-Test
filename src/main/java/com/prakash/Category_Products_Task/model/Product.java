package com.prakash.Category_Products_Task.model;





/*-------------------  NOTE :-  JSON format like this to add product--------------------------------
{
    
    "productName" : "ABC",
    "productPrice" :1200,

    "category":{

        "categoryId":1   Specify the Existing Category Id here..
        
        }
        
}*/



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="productId")
    private Long productId;
    @Column(name="productName")
    private String productName;
    @Column(name="productPrice")
    private double productPrice;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonBackReference
    private Category category;

    public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Long productId, String productName, double productPrice, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}   
    
}

