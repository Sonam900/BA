package com.sonam.service.impl;

import com.sonam.Repo.CategoryRepo;
import com.sonam.entity.Category;
import com.sonam.exceptions.TitleAlreadyExist;
import com.sonam.payLoad.CategoryDto;
import com.sonam.service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category createCategory(CategoryDto categoryDto) {
		if(categoryRepo.existsByTitle(categoryDto.getTitle())) {
			throw new TitleAlreadyExist("Title is already available");
		}
		
		Category newCategory = new Category();
		
		newCategory.setCategoryId(categoryDto.getCategoryId());
		newCategory.setTitle(categoryDto.getTitle());
		return categoryRepo.save(newCategory);

	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		
		List<Category> CategoryList = categoryRepo.findAll();
		
		return CategoryList;
	}

	
}
