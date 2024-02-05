package com.sonam.service.impl;

import com.sonam.Repo.CommentRepo;
import com.sonam.Repo.PostRepo;
import com.sonam.entity.Comment;
import com.sonam.entity.Post;
import com.sonam.exceptions.ResourceNotFoundException;
import com.sonam.payLoad.CommentDto;
import com.sonam.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private PostRepo postrepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, long postId) {

		// Fetch the post
		Post post = postrepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

		// Create a Comment entity from the DTO
		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		// Check if 'uid' of the user in the CommentDto is not null
		if (commentDto.getUser() == null || commentDto.getUser().getUid() == null) {
			throw new IllegalArgumentException("UID of the user in CommentDto cannot be null");
		}

		// Set the post and user for the comment
		comment.setPost(post);
		comment.setUser(commentDto.getUser()); // Assuming you have a setUser method in the Comment entity

		// Save the comment
		Comment savedComment = this.commentRepo.save(comment);

		// Map and return the saved comment as CommentDto
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public boolean deleteComment(Long commentId) {
		Comment com = commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		if (com != null) {
			commentRepo.delete(com);
			return true;
		} else
			return false;
	}

	@Override
	public boolean updateComment(Long commentId, CommentDto newComment) {
		Optional<Comment> optionalComment = commentRepo.findById(commentId); 
		
		if(optionalComment.isPresent() && newComment != null) {
			Comment comment = optionalComment.get();
			
			if(newComment.getComment() != null) {
				comment.setComment(newComment.getComment());
			}
			
			commentRepo.save(comment);
			return true;
		} else {
		return false;
	}

	}
}
