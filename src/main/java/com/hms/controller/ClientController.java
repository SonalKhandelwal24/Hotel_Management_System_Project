package com.hms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.utility.*;
import com.hms.dto.ClientDTO;
import com.hms.entity.Client;
import com.hms.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService cltService;
	
	@Autowired
	ClientConverter CltConverter;
	
	@PostMapping("/saveClient")
	public ClientDTO saveClient(@Valid @RequestBody ClientDTO cDto) 
	{
		final Client clt = CltConverter.convertDtoTocltEntity(cDto);
		return cltService.saveClient(clt);		
	}
	
	@GetMapping("/getClient/{cltId}")
	public ClientDTO getClientById(@PathVariable("cltId") int id)
	{
		return cltService.getClientById(id);
	}
	
	@GetMapping("/getAllClients")
	public List<ClientDTO> getAllClients()
	{
		return cltService.getAllClients();				
	}
	
	@PutMapping("/updateClient/{id}")
	public ClientDTO updateClient(@PathVariable("id") int cltId, 
		@Valid @RequestBody	ClientDTO cltDto)
	{
		final Client clt = CltConverter.convertDtoTocltEntity(cltDto);
		return cltService.updateClient(cltId, clt);
	}
	
	@DeleteMapping("/deleteCltById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int cltId)
	{
		
		cltService.deleteClientById(cltId);		
		return new ResponseEntity<String>("Client with id "+cltId+" deleted successfully!", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll()
	{
		cltService.deleteAll();
		return new ResponseEntity<String>("All clients details deleted successfully!", HttpStatus.OK);		
	}
	
	@GetMapping("/getClientByName/{name}")
	public List<ClientDTO> findClientByName(@PathVariable("name") String name)
	{		
		return cltService.getClientByName(name);		
	}
	
//	@GetMapping("/getClientByEmail/{email}")
//	public ClientDTO findClientByEmail(@PathVariable("email") String email)
//	{		
//		return cltService.getClientByEmail(email);		
//	}
	
}

