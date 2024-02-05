package com.sonam.service.impl;

import com.sonam.Repo.CategoryRepo;
import com.sonam.Repo.PostRepo;
import com.sonam.Repo.UserRepo;
import com.sonam.entity.Post;
import com.sonam.entity.User;
import com.sonam.entity.Category;
import com.sonam.exceptions.ResourceNotFoundException;
import com.sonam.payLoad.PostDto;
import com.sonam.service.PostService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postrepo;

	@Autowired
	private CategoryRepo categoryrepo;

	@Autowired
	private UserRepo userrepo;

	@Override
	public String createPost(PostDto postDto, String title, Long uid) {
	    
	    User user = userrepo.findById(uid)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "uid", uid));

	    // Find or create the category based on the provided title
	    Optional<Category> cat = categoryrepo.findByTitle(title);
	    Category category;
	    if (cat.isEmpty()) {
	        category = new Category();
	        category.setTitle(title);
	        // Save the newly created category
	        category = categoryrepo.save(category);
	    } else {
	        category = cat.get();
	    }

	    String message = "Post not created";
	    Post post = new Post();
	    BeanUtils.copyProperties(postDto, post);

	    // Set the user and category for the post
	    post.setUser(user);
	    post.setCategory(category);

	    // Save the post in the database
	    Post savedPost = postrepo.save(post);

	    if (savedPost != null) {
	        message = "Post created, in category: " + category.getTitle();
	    } else {
	        message = "Failed to create post.";
	    }

	    return message;
	}

	@Override
	public boolean updatePost(long postId, PostDto updatePostData) {
	    Optional<Post> optionalPost = postrepo.findById(postId);

	    if (optionalPost.isPresent() && updatePostData != null) {
	        Post post = optionalPost.get();

	        if (updatePostData.getTitle() != null) {
	            post.setTitle(updatePostData.getTitle());
	        }

	        if (updatePostData.getContent() != null) {
	            post.setContent(updatePostData.getContent());
	        }

	        if (updatePostData.getImage() != null) {
	            post.setImage(updatePostData.getImage());
	        }

	        postrepo.save(post);
	        return true;
	    } else {
	        return false;
	    }
	}



	@Override
	public boolean deletePost(long postId) {
		Optional<Post> optionalPost = postrepo.findById(postId);
		if (optionalPost.isPresent()) {
			postrepo.deleteById(postId);
			return true;
		} else
			return false;
	}

	
	@Override
	public List<Post> getAllPost() {
		List<Post> AllPost = postrepo.findAll();
		return AllPost;
	}

	@Override
	public Post getPostById(long postId) {
		Optional<Post> optionalPost = postrepo.findById(postId);
		return optionalPost.orElse(null);
	}
}
