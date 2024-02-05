package com.sonam.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonam.entity.Role;
import com.sonam.payLoad.RoleDto;
import com.sonam.service.RoleService;

@RestController
@RequestMapping("/api/v1")
public class RoleController {

	@Autowired
	private RoleService roleservice;
	
	@PostMapping("/createRole")
	public ResponseEntity<Role> createRole(@RequestBody RoleDto roleDto){
	Role newRole = roleservice.createRole(roleDto);	
		return new ResponseEntity<>(newRole, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/AllRole")
	public ResponseEntity<List<Role>> getAllRole() {
		List<Role> roles = roleservice.getAllRole();
		return new ResponseEntity<>(roles,HttpStatus.OK);
		
	}
	
}
