package com.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	
	@Column(length = 100, nullable = false)
	private String locality;
	
	@Column(length = 50, nullable = false)
	private String city;
	
	@Column(length = 30, nullable = false)
	private String state;
	
	@Column(nullable = false)	//not null
	private int pincode;

	
}
