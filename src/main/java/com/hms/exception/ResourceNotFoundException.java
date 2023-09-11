package com.hms.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{     //custom class

	private static final long serialVersionUID = 1L;
	
	private String resourceName;	//searching for what? like client, manager
	private String fieldName;		//searching for which field?
	private Object fieldValue;		//which field(id/name) we'r searching
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) 
	{
		super(String.format("%s not found with %s : '%s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}

 