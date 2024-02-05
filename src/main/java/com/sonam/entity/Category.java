package com.sonam.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@Entity
@Table(name="Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name="title")
    private String title;

   // @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
   
    @ManyToMany
	@JoinTable(
	    name = "categoriesPosts",
	    joinColumns = @JoinColumn(name = "categoryId", referencedColumnName = "CategoryId"),
	    inverseJoinColumns = @JoinColumn(name = "postId", referencedColumnName = "PostId")
	)
    
    private List<Post> categoriesPosts = new ArrayList<>();

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

	public List<Post> getCategoriesPosts() {
		return categoriesPosts;
	}

	public void setCategoriesPosts(List<Post> categoriesPosts) {
		this.categoriesPosts = categoriesPosts;
	}

	public void add(Category category) {
		// TODO Auto-generated method stub
		
	}




}

