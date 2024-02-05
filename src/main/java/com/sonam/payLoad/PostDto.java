package com.sonam.payLoad;

import com.sonam.entity.Category;
import com.sonam.entity.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PostDto {
	
    private Long postId;

    @NotBlank
    private String title;

    private String content;

    private String image;

    private User user;

    private Category category;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public PostDto(@NotBlank String title, String content, String image, User user, Category category) {
		super();
		this.title = title;
		this.content = content;
		this.image = image;
		this.user = user;
		this.category = category;
	}

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}


}
