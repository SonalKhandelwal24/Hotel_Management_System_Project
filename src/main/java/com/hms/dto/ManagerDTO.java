package com.hms.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class ManagerDTO extends UserDTO{

	@NotNull(message = "hotel name is required")
	private String hotelName;
	
//	@Column(unique = true)
//	private int managerId;
	
	@NotNull(message = "noOfStaff is required")
	private int noOfStaff;
	
}
