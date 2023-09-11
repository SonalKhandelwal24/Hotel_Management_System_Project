package com.hms.utility;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.hms.dto.RoomDTO;
import com.hms.entity.Room;

@Component
public class RoomConverter {

	//method to convert dto to client entity
	public Room convertDtoToRoomEntity(RoomDTO rDto)
	{
		Room room = new Room();
		
		if(rDto!=null) 
		{
				BeanUtils.copyProperties(rDto, room);
		}
		
			return room;
		}
		
		//method to convert client entity to dto
			public RoomDTO convertEntityToRoomDto(Room room)
			{
				RoomDTO rDto = new RoomDTO();
				
				if(room!=null) 
				{
					BeanUtils.copyProperties(room, rDto);
				}
				
				return rDto;
			}
	}