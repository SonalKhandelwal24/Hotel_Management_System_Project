package com.hms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dto.BillingSystemDTO;
import com.hms.dto.RoomDTO;
import com.hms.entity.BillingSystem;
import com.hms.entity.Room;
import com.hms.service.BillingSystemService;
import com.hms.utility.BillingSystemConverter;
import com.hms.utility.RoomConverter;

@RestController
public class BillingSystemController {

	@Autowired
	BillingSystemService billingSystemService;
	
	@Autowired
	BillingSystemConverter billingSystemConverter;
	
	@Autowired
	RoomConverter roomConverter;
	
	@PostMapping("/saveBillingSystem")
	public BillingSystemDTO saveBillingSystem(@Valid @RequestBody RoomDTO rDto) 
	{
//		final BillingSystem bs = RoomConverter.convertDtoToBsEntity(rDto);
		BillingSystem bs = (BillingSystem) roomConverter.convertDtoToRoomEntity(rDto);
		return billingSystemService.saveBilling(bs);
	}
	
	
}
