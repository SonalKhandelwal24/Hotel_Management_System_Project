package com.hms.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.hms.dto.BillingSystemDTO;
import com.hms.entity.BillingSystem;

@Component
public class BillingSystemConverter {
	
	//method to convert dto to client entity
		public BillingSystem convertDtoToBsEntity(BillingSystemDTO bDto)
		{
			BillingSystem bs = new BillingSystem();
			
			if(bDto!=null) 
			{
				BeanUtils.copyProperties(bDto, bs);
			}
			
			return bs;
		}
		
		//method to convert client entity to dto
			public BillingSystemDTO convertEntityToBsDto(BillingSystem bs)
			{
				BillingSystemDTO bDto = new BillingSystemDTO();
				
				if(bs!=null) 
				{
					BeanUtils.copyProperties(bs, bDto);
				}
				
				return bDto;
			}

}
