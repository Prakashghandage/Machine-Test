package com.prakash.Category_Products_Task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prakash.Category_Products_Task.model.Category;


public interface CategoryRepository extends JpaRepository<Category , Long>{

}
