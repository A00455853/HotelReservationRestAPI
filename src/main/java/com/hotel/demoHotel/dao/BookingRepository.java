package com.hotel.demoHotel.dao;

import com.hotel.demoHotel.model.BookingDetails;
import com.hotel.demoHotel.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingDetails,Integer> {


}
