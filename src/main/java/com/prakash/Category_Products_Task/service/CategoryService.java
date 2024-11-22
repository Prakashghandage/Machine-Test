package com.prakash.Category_Products_Task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prakash.Category_Products_Task.exception.ResourceNotFoundException;
import com.prakash.Category_Products_Task.model.Category;
import com.prakash.Category_Products_Task.repository.CategoryRepository;



@Service
public class CategoryService {
	
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
    	
    	Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        return category;
    }
	 
    public Category updateCategoryById(Long id, Category categoryDetails) {
    	
    	
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        
        if(categoryDetails.getCategoryName()!=null)
        {
        	 category.setCategoryName(categoryDetails.getCategoryName());
        }
        
        return categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        categoryRepository.delete(category);
    }
}
