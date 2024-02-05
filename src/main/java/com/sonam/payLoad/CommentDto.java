package com.sonam.payLoad;

import com.sonam.entity.Post;
import com.sonam.entity.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentDto {
	
    private Long commentId;
    
    @NotBlank
    private String comment;

    private User user;

    private Post post;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public CommentDto(@NotBlank String comment, User user, Post post) {
		super();
		this.comment = comment;
		this.user = user;
		this.post = post;
	}

	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}
