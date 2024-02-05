package com.sonam.service;

import com.sonam.payLoad.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, long post_id);

    boolean deleteComment(Long commentId);

    public boolean updateComment(Long commentId, CommentDto newComment);
  
    //public boolean updateComment(Long commentId,//CommentDto updateCommentData);
    
    
}
