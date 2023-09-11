package com.hms.dto;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.hms.entity.Client;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class RoomDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "Please provide checkInDate")	
	private	LocalDate checkInDate;
		
	@NotNull(message = "Please provide checkOutDate")
	private	LocalDate checkOutDate;	
	
	@OneToOne
	private BillingSystemDTO billingSystemDTO;
	
}
