package com.sonam.payLoad;

import jakarta.validation.constraints.NotBlank;

public class LoginDto {

	
	@NotBlank
	private String name;
	
	@NotBlank
	private String password;

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LoginDto(@NotBlank String name, @NotBlank String password) {
		super();
		this.name = name;
		this.password = password;
	}


	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
