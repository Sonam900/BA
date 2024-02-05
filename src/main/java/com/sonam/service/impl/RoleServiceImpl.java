package com.sonam.service.impl;

import com.sonam.Repo.RoleRepo;
import com.sonam.entity.Role;
import com.sonam.payLoad.RoleDto;
import com.sonam.service.RoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo rolerepo;
	
	@Override
	public Role createRole(RoleDto roleDto) {
		// TODO Auto-generated method stub
		Role newrole = new Role();
		newrole.setRole_id(roleDto.getRole_id());
		newrole.setRole_name(roleDto.getRole_name());
		
		return rolerepo.save(newrole);
	}

	@Override
	public List<Role> getAllRole() {
		List<Role> roleRecord = rolerepo.findAll();
		return roleRecord;
	}


}
