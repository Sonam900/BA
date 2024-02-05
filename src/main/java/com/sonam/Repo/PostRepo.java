package com.sonam.Repo;

import com.sonam.entity.Post;
import com.sonam.entity.User;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository <Post, Long> {
	
	List<Post> findByUser(User user);

	/*
	 * @Query("SELECT DISTINCT p FROM Post p JOIN p.category c WHERE c.title = :title"
	 * ) Page<Post> findByTitle(@Param("title") String title, Pageable pageable);
	 */

	    Page<Post> findByTitle(String title, Pageable pageable);
	}


