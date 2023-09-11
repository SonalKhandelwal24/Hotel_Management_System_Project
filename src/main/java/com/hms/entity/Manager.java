package com.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.hms.dto.ManagerDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Manager extends User {
	
	@Column
	private String hotelName;
	
	@Column(nullable = false)
	private int noOfStaff;


}
