package com.hotel.demoHotel.dao;

import com.hotel.demoHotel.model.Hotel;
import com.hotel.demoHotel.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Rooms,Integer> {
}
