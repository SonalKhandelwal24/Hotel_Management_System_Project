package com.hms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "client_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client extends User{
	
	@Column(nullable = false, unique = true, length = 10)
	private String contact;
		
	//one client have only one address
	@OneToOne
	private Address address;
	
	//but one client may have many rooms
	@OneToOne
	private Room room;

}
