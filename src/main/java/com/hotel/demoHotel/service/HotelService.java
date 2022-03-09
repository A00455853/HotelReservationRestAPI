package com.hotel.demoHotel.service;

import java.util.List;
import java.util.Optional;

import com.hotel.demoHotel.model.Hotel;
import com.hotel.demoHotel.model.MessageResponse;
import org.springframework.stereotype.Service;



@Service


public interface HotelService {
	MessageResponse createHotel(Hotel hotel);
    Optional<Hotel> updateHotel(Integer id, Hotel hotel);
    void deleteHotel(Integer id);
    Hotel getHotelDetailsById(Integer id);
    List<Hotel> getAllHotel();


}
