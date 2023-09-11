package com.hms.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class BillingSystemDTO extends RoomDTO {

	@NotNull(message = "noOfRooms is required")
	private	int noOfRooms;		//3
	
	@NotNull(message = "noOfDays is required")
	private int noOfDays;		//2	
	
	@NotNull(message = "room_price is required")
	private String room_price;
	
}
