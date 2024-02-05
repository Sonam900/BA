package com.sonam.payLoad;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    private Long uid;

	@NotNull
	@Size(min = 2, message = "Name should not be less then two words.")
	@JsonProperty("Name")
    private String name;
	
    @Email(message = "Invalid Email. Please check the Email and try again.")
    @NotBlank
    @JsonProperty("Email")
    private String email;
    
    @NotNull
	@Size(min = 6, message = "password should have more than six words.")
	@JsonProperty("Password")
    private String password;
    
    @NotNull
	@Size(min = 2, message = "It should have more than two words.")
	@JsonProperty("About")
    private String about;
    
    

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public UserDto(@NotNull @Size(min = 2, message = "Name should not be less then two words.") String name,
			@Email(message = "Invalid Email. Please check the Email and try again.") @NotBlank String email,
			@NotNull @Size(min = 6, message = "password shouyld have more than siz words.") String password,
			@NotNull @Size(min = 2, message = "It should have more than two words.") String about) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	public UserDto() {
		
		// TODO Auto-generated constructor stub
	}

	
}
