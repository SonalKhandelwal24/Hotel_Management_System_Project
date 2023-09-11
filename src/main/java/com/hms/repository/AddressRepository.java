package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
