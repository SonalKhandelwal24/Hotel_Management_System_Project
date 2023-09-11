package com.hms.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.hms.dto.ManagerDTO;
import com.hms.entity.Manager;

@Component
public class ManagerConverter {

		//method to convert dto to client entity
		public Manager convertDtoToMngEntity(ManagerDTO mDto)
		{
			Manager mng = new Manager();
			
			if(mDto!=null) 
			{
				BeanUtils.copyProperties(mDto, mng);
			}
			
			return mng;
		}
		
		//method to convert client entity to dto
			public ManagerDTO convertEntityToMngDto(Manager mng)
			{
				ManagerDTO mDto = new ManagerDTO();
				
				if(mng!=null) 
				{
					BeanUtils.copyProperties(mng, mDto);
				}
				
				return mDto;
			}
	}
