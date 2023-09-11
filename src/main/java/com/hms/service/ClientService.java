package com.hms.service;

import java.util.List;

import com.hms.dto.ClientDTO;
import com.hms.entity.Client;
import com.hms.exception.ResourceNotFoundException;


public interface ClientService {

	//method used to add client details into the database	
	ClientDTO saveClient(Client clt);
		
	//method to fetch client details using client id
	ClientDTO getClientById(int id) throws ResourceNotFoundException;
		
	//method to fetch all client details 
	List<ClientDTO> getAllClients();
		
	//method to update client details that are present in the database
	ClientDTO updateClient(int cltId, Client clt);
		
	//method to delete one client details 
	void deleteClientById(int cltId);
		
	//method to delete all the client from the database
	void deleteAll();
		
	//method of fetch client details using name
	List<ClientDTO> getClientByName(String name);
		
	//method of fetch client details using email
	ClientDTO getClientByEmail(String email);	
		
}
