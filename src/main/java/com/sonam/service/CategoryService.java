package com.sonam.service;

import java.util.List;

import com.sonam.entity.Category;
import com.sonam.payLoad.CategoryDto;

public interface CategoryService {
	
	public Category createCategory(CategoryDto categoryDto);
	
	public List<Category> getAllCategory();
}
