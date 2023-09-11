package com.hms.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.hms.entity.Address;
import com.hms.entity.Manager;
import com.hms.entity.Room;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO extends UserDTO{
	
	@NotNull(message = "Contact is required")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Invalid contact details")
	@Size(min=10, max=10, message = "Min. and Max. 10 digits allowed")
	private String contact;
		
	//one client have only one address
	@OneToOne
	private Address address;
	
	//but one client may have many rooms
	@OneToOne
	private Room room;
	
	
}
