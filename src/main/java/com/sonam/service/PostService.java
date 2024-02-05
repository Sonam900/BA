package com.sonam.service;

import java.util.List;

import com.sonam.entity.Post;
import com.sonam.payLoad.PostDto;

public interface PostService {

    String createPost(PostDto postDto,String title, Long uid);

    public boolean updatePost(long postId, PostDto updatePostData);
    
    boolean deletePost(long postId);
    
    public  List<Post> getAllPost();
    
    public Post getPostById(long postId);
    
    
}
