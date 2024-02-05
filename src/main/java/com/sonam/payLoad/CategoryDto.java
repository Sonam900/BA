package com.sonam.payLoad;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CategoryDto {
	
    private Long categoryId;
    
    @NotNull
	@Size(min = 2, message = "Title should not be less then two words.")
	@JsonProperty("Title")
    private String title;
    
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CategoryDto(String title) {
		super();
		this.title = title;
	}

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
