package com.sonam.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="uid")
    private Long uid;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @JsonIgnore
    @Column(name = "Password")
    private String password;

    @Column(name = "About")
    private String about;

    @JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createDate = new Date();

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date updateDate = new Date();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(mappedBy = "rolesUsers", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Role> roles = new ArrayList<>();

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User(String name, String email, String password, String about, Date createDate, Date updateDate,
			List<Post> posts, List<Comment> comments, List<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.posts = posts;
		this.comments = comments;
		this.roles = roles;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}
