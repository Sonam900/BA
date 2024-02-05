package com.sonam.service;

import com.sonam.entity.User;
import com.sonam.payLoad.UserDto;


import java.util.List;

public interface UserService {

	public User createUser(UserDto userDto);
	
    public boolean updateUser(long uid, UserDto updatedUserData);

    public boolean deleteUser(long uid);

    public User getUserById(long uid);

    public List<User> getAllUser();

	public String userLogin(String name, String password);

	public String forgotPassword(String name);
	
	//public String changePassword()
}
