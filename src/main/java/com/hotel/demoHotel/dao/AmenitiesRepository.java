package com.hotel.demoHotel.dao;

import com.hotel.demoHotel.model.Amenities;
import com.hotel.demoHotel.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenitiesRepository extends JpaRepository<Amenities,Integer> {


}
