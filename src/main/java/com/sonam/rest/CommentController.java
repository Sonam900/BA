package com.sonam.rest;

import com.sonam.payLoad.CommentDto;
import com.sonam.service.impl.CommentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

	@Autowired
	private CommentServiceImpl commentServiceImpl;

	@PostMapping("/post/comments/{postId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment,@PathVariable Long postId) {

		if (comment.getUser() == null || comment.getUser().getUid() == null) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

		CommentDto com = commentServiceImpl.createComment(comment, postId);

		return new ResponseEntity<CommentDto>(com, HttpStatus.CREATED);
	}

	
	@DeleteMapping("/delete/{commentId}")
	public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
	    boolean deleted = commentServiceImpl.deleteComment(commentId);
	    if (deleted) {
	    	
	        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	        
	    } else {

	        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("/update/{commentId}")
	public ResponseEntity<String> updateComment(@PathVariable Long commentId,@RequestBody CommentDto newComment){
		boolean NewComment = commentServiceImpl.updateComment(commentId, newComment);
		if(NewComment) {
			return new ResponseEntity<>("Comment updated successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Comment not found.", HttpStatus.NOT_FOUND);
		}
	}
}
