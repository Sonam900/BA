package com.sonam.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonam.entity.Category;
import com.sonam.payLoad.CategoryDto;
import com.sonam.service.CategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/PostCategory")
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto) {
		Category newCategory = categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<>(newCategory,HttpStatus.CREATED);
	}
	
	@GetMapping("/allCategory")
	public ResponseEntity<List<Category>>getAllCategory(){
		List<Category> category = categoryService.getAllCategory();
		return new ResponseEntity<>(category,HttpStatus.OK);
		
	}
	
}
