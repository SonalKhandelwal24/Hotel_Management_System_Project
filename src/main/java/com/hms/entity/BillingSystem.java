package com.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
public class BillingSystem extends Room{

	@Column(nullable = false)
	private	int noOfRooms;		//3
	
	@Column(nullable = false)
	private int noOfDays;		//2	
	

	@Column(nullable = false, length = 10)
	private String room_price;	

	
}

// = billingsytemrepository.getnoofrooms*noOfDays*(roomrepository.getroomprice);
//3*2=6*1000=6000
//one room = 1000;
//2 rooms = 2000;
//3 = 3*2000 = 6000