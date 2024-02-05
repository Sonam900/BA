package com.sonam.service;

import java.util.List;

import com.sonam.entity.Role;
import com.sonam.payLoad.RoleDto;

public interface RoleService {
	
	public Role createRole( RoleDto roleDto); 
	
	public List<Role> getAllRole();
	
	
}
