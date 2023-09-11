package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
