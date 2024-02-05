package com.sonam.Repo;
import com.sonam.entity.Category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository <Category, Long> {
	
	boolean existsByTitle(String title);
	
	Optional<Category> findByTitle(String title);
}
