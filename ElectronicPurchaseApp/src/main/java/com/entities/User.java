package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Users")
public class User {
	

	@Id
    private int userId;
	
	@NotNull
	@Size(min=6,message="Password atleast 6 character in length")
	@Column(name="Password")
	private String password;
	
	@NotNull
	@Column(name="Role")
	private String role;
	
	public User() 
	{
		
	}
	
	public User(@NotNull @Size(min = 6, message = "Password atleast 6 character in length") String password,
			@NotNull String role) 
	{
		super();
		this.password = password;
		this.role = role;
	}

	public int getUserId() 
	{
		return userId;
	}

	public void setUserId(int userId) 
	{
		this.userId = userId;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getRole() 
	{
		return role;
	}

	public void setRole(String role) 
	{
		this.role = role;
	}

	@Override
	public String toString()
	{
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	
	
	
}
