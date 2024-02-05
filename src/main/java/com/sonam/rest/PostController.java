package com.sonam.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonam.entity.Post;
import com.sonam.payLoad.PostDto;
import com.sonam.service.impl.PostServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

	@Autowired
	private PostServiceImpl postServiceImpl;

	@PostMapping("/{uid}/{categoryId}")
	public ResponseEntity<Map<String, String>> createPost(@Valid @RequestBody PostDto postDto,
			@PathVariable("categoryId") String title, @PathVariable("uid") Long uid) {

		String message = "Message";
		String createdPost = postServiceImpl.createPost(postDto, title, uid);
		Map<String, String> response = new HashMap<>();
		response.put(message, createdPost);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/update/{postId}")
	public ResponseEntity<String> updatePost(@PathVariable long postId, @RequestBody PostDto updatePostData) {
		boolean updatedpost = postServiceImpl.updatePost(postId, updatePostData);
		if (updatedpost) {
			return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
		}
	}

	
	@DeleteMapping("/delete/{postId}")
	public ResponseEntity<String> deletePost(@PathVariable long postId) {
		boolean deletedPost = postServiceImpl.deletePost(postId);
		if (deletedPost) {
			return new ResponseEntity<>("Post Deleted Successfully", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Post doesnot exist", HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping("/AllPost")
	public ResponseEntity<List<Post>> getAllPost() {

		List<Post> post = postServiceImpl.getAllPost();

		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	
	@GetMapping("/get/{postId}")
	public ResponseEntity<Post> getPostById(@PathVariable long postId) {
		Post getpost = postServiceImpl.getPostById(postId);
		if (getpost != null) {
			return new ResponseEntity<>(getpost, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
