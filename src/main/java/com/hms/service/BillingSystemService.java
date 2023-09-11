package com.hms.service;

import com.hms.dto.BillingSystemDTO;
import com.hms.entity.BillingSystem;
import com.hms.entity.Room;

public interface BillingSystemService {

	BillingSystemDTO saveBilling(Room room);
}
