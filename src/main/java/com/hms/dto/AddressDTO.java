package com.hms.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class AddressDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	
	@Size(max=100, message = "Max. limit 100 characters")
	@NotNull(message = "Locality is required")
	private String locality;
	
	@Size(max=50, message = "Max. limit 50 characters")
	@Size(min=2, message = "Min. 2 characters required")
	@NotNull(message = "City is required")
	private String city;
	
	@Size(max=30, message = "Max. limit 30 characters")
	@Size(min=3, message = "Min. 3 characters required")
	@NotNull(message = "State is required")
	private String state;
	
	@Size(max=6, min=6, message = "6 characters required")
	@NotNull(message = "Pincode is required")
	private int pincode;
	
}
