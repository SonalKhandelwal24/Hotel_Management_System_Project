package com.hms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.utility.ClientConverter;

import lombok.extern.slf4j.Slf4j;

import com.hms.dto.ClientDTO;
import com.hms.entity.Address;
import com.hms.entity.BillingSystem;
import com.hms.entity.Client;
import com.hms.entity.Role;
import com.hms.entity.Room;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repository.AddressRepository;
import com.hms.repository.BillingSystemRepository;
import com.hms.repository.ClientRepository;
import com.hms.repository.RoleRepository;
import com.hms.repository.RoomRepository;
import com.hms.service.BillingSystemService;
import com.hms.service.ClientService;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

	//logger statically created
	private static final Logger log = LoggerFactory.getLogger(Client.class);
		
	@Autowired
	ClientRepository cltRepository;
	
	@Autowired
	AddressRepository addRepository;
	
	@Autowired
	RoleRepository 	roleRepository;
	
	@Autowired
	ClientConverter cltConverter;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	BillingSystemRepository billingSystemRepository;
	
	
	@Override
	public ClientDTO saveClient(Client clt) {
		
		String user = clt.getEmail().substring(0, clt.getEmail().lastIndexOf('@')); 	//0, index of @
		clt.setUserName(user);
		
		String pass = clt.getName().substring(0,3).toLowerCase();
		clt.setPassword(pass+"123");
				
		//setting the role
		Role role = roleRepository.findById(2).get();
		clt.setRole(role);
						
		//assigning room price
//		billingSystemRepository.save(new Room().getBillingSystem());
		roomRepository.save(clt.getRoom());
	
				
		//assigning address details		
		addRepository.save(clt.getAddress());
		
		cltRepository.save(clt);	
		
		log.info("Client with details "+clt.toString()+" saved successfully.");
		
		//saving the object to the database				
		ClientDTO cDto = cltConverter.convertEntityTocltDto(clt);
		
		return cDto;
	}

	@Override
	public ClientDTO getClientById(int cltId) throws ResourceNotFoundException {
		
		Client clt = cltRepository.findById(cltId).orElseThrow(
				()-> new ResourceNotFoundException("Client", "id", cltId));
		
		log.info("Student details with id "+cltId+" was fetched");
		return cltConverter.convertEntityTocltDto(clt);	
	}	

	@Override
	public List<ClientDTO> getAllClients() {
		
		List<Client> clt = cltRepository.findAll();
		
		List<ClientDTO> cDtos = new ArrayList<>();
		
		for(Client c : clt)
		{
			
			cDtos.add(cltConverter.convertEntityTocltDto(c));			
		}	
		
		log.info("All Client details are fetched.");
		
		return cDtos;
	}

	@Override
	public ClientDTO updateClient(int cltId, Client clt) throws ResourceNotFoundException{
		
		//fetch the client details using the id		
		Client existStd = cltRepository.findById(cltId).orElseThrow(()->
		new ResourceNotFoundException("Client", "id", cltId));
				
		//updating the existing clients details with the updated details
		existStd.setName(clt.getName());
		existStd.setEmail(clt.getEmail());
		existStd.setAddress(clt.getAddress());
		existStd.setContact(clt.getContact());
		existStd.setRoom(clt.getRoom());
					
		//saving the changes that we are done
		cltRepository.save(existStd);
				
		log.info("Update Student details.");
		
		return cltConverter.convertEntityTocltDto(existStd);		
	}
	
	
	@Override
	public void deleteClientById(int cltId) {
	
		Client clt = cltRepository.findById(cltId).orElseThrow(()->
		new ResourceNotFoundException("Client", "Id", cltId));
	
		Address add = clt.getAddress();
	
		if(add!=null)
		{
			clt.setAddress(null);
			addRepository.delete(add);
		}
	
		cltRepository.delete(clt);
		
		log.info("Client details with id "+cltId+" was deleted!");
}

	@Override
	public void deleteAll() {

		cltRepository.deleteAll();	
		
		log.info("Client details are deleted.");
	}

	@Override
	public List<ClientDTO> getClientByName(String name) {

		List<Client> clients = cltRepository.findClientByName(name);
		
		List<ClientDTO> cDtos = new ArrayList<>();
		
		for(Client c : clients)
		{
			cDtos.add(cltConverter.convertEntityTocltDto(c));			
		}
		
		log.info("Get client details by name "+name+" is fetched successfully!!");
		
		return cDtos;
	}


	@Override
	public ClientDTO getClientByEmail(String email) {
					
		Client clt = cltRepository.findByEmail(email).orElseThrow(()->
		new ResourceNotFoundException("Client", "email", email));
		
		log.info("Get client details by name "+email+" is fetched successfully!!");
					
		return cltConverter.convertEntityTocltDto(clt);
		}
}




