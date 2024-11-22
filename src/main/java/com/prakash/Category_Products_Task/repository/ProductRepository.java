package com.prakash.Category_Products_Task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prakash.Category_Products_Task.model.Product;

public interface ProductRepository  extends JpaRepository<Product,Long>{

}
