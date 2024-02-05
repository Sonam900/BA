package com.sonam.Repo;

import com.sonam.entity.User;
import com.sonam.payLoad.UserDto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <User, Long>{

	boolean existsByEmail(String email);

	Optional <User> findByName(String name);

}
