package com.sonam.payLoad;

import lombok.Data;

@Data
public class RoleDto {

    private Long role_id;
    
    private String role_name;

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public RoleDto(String role_name) {
		super();
		this.role_name = role_name;
	}

	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
