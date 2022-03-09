package com.hotel.demoHotel.dao;

import com.hotel.demoHotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface HotelRepository extends JpaRepository<Hotel,Integer> {

}
