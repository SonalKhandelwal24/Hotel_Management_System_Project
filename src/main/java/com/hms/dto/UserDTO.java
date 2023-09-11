package com.hms.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hms.entity.Role;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class UserDTO {

	private int id;
	
	@NotNull(message = "Name is required")
	@Size(min=2, message = "Min. 2 characters required")
	@Size(max=30, message = "Max. 30 characters allowed")
	@NotBlank(message = "Please enter correct name")
	private String name;
	
	@Size(max=50, message= "Max. 30 characters allowed")
	@Email(message = "Invalid email")
	private String email;	
	
	private String userName;
		
	private String password;
	
	@OneToOne		//one user can have only one role
	private Role role;	
	
	
}
