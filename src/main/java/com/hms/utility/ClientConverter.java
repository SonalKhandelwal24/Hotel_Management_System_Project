package com.hms.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.hms.dto.ClientDTO;
import com.hms.entity.Client;

@Component
public class ClientConverter {

	//method to convert dto to client entity
	public Client convertDtoTocltEntity(ClientDTO cDto)
	{
		Client clt = new Client();
		
		if(cDto!=null) 
		{
			BeanUtils.copyProperties(cDto, clt);
		}
		
		return clt;
	}
	
	//method to convert client entity to dto
		public ClientDTO convertEntityTocltDto(Client clt)
		{
			ClientDTO cDto = new ClientDTO();
			
			if(clt!=null) 
			{
				BeanUtils.copyProperties(clt, cDto);
			}
			
			return cDto;
		}
}
