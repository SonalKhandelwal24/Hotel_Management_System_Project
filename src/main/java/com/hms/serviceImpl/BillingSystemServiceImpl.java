package com.hms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dto.BillingSystemDTO;
import com.hms.dto.RoomDTO;
import com.hms.entity.BillingSystem;
import com.hms.entity.Room;
import com.hms.repository.BillingSystemRepository;
import com.hms.repository.RoomRepository;
import com.hms.service.BillingSystemService;
import com.hms.utility.BillingSystemConverter;
import com.hms.utility.RoomConverter;

@Service
public class BillingSystemServiceImpl implements BillingSystemService{

	@Autowired
	BillingSystemRepository billingSystemRepository;
	
	@Autowired
	BillingSystemConverter billingSystemConverter;
	
	@Autowired
	RoomRepository roomrepository;
	
	@Autowired
	RoomConverter roomConverter;
	
	@Override
	public BillingSystemDTO saveBilling(Room room) {
		
		billingSystemRepository.save(room.getBillingSystem());
//		billingSystemRepository.save(room);
		
		BillingSystemDTO bDto = (BillingSystemDTO) roomConverter.convertEntityToRoomDto(room);
		
		return bDto;
	}

}
