package com.sonam.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="Role")
@Data

public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="role_id")
    private Long role_id;

    @Column(name="role_name")
    private String role_name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "rolesUsers", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"), inverseJoinColumns = @JoinColumn(name = "uid", referencedColumnName = "uid"))
	private List<User> rolesUsers = new ArrayList<>();

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

	public List<User> getRolesUsers() {
		return rolesUsers;
	}

	public void setRolesUsers(List<User> rolesUsers) {
		this.rolesUsers = rolesUsers;
	}

	public Role(String role_name, List<User> rolesUsers) {
		super();
		this.role_name = role_name;
		this.rolesUsers = rolesUsers;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	
    
}
