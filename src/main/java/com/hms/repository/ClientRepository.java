package com.hms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hms.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query("from Client where name=:e")
	List<Client> findClientByName(@Param("e") String name);

	Optional<Client> findByEmail(String email);

}
