package com.prakash.Category_Products_Task.service;





/*-------------------  NOTE :-  JSON format like this to add product--------------------------------
{
    
    "productName" : "ABC",
    "productPrice" :1200,

    "category":{

        "categoryId":1   Specify the Existing Category Id here..
        
        }
        
}*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prakash.Category_Products_Task.exception.ResourceNotFoundException;
import com.prakash.Category_Products_Task.model.Product;
import com.prakash.Category_Products_Task.repository.ProductRepository;


@Service
public class ProductService {
	
    @Autowired
    private ProductRepository productRepository;
    

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product createProduct(Product product) {
    	
        return productRepository.save(product);
    }
    
    public Product getProductById(Long id) {
    	
	 Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return product;
    }
	 
    public Product updateProductById(Long id, Product productDetails) {
    	
    	Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    	      
    	      if(productDetails.getProductName()!=null)
    	      {
    	    	  product.setProductName(productDetails.getProductName());
    	      }
    		  
    	      if(productDetails.getProductPrice()!=0)
    	      {
    	    	  product.setProductPrice(productDetails.getProductPrice());
    	      }
    		 
    	      if(productDetails.getCategory()!=null)
    	      {
    	    	  product.setCategory(productDetails.getCategory());
    	      }
    	
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
    	Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    	productRepository.delete(product); 
    }
}


