package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
