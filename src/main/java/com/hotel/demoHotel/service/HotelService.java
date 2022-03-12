package com.hotel.demoHotel.service;

import java.util.List;
import java.util.Optional;

import com.hotel.demoHotel.DTO.AddRooms;
import com.hotel.demoHotel.DTO.BookHotelRoom;
import com.hotel.demoHotel.DTO.BookRoom;
import com.hotel.demoHotel.DTO.MessageResponse;
import com.hotel.demoHotel.model.*;
import org.springframework.stereotype.Service;



@Service


public interface HotelService {
	MessageResponse createHotel(Hotel hotel);
    Optional<Hotel> updateHotel(Integer id, Hotel hotel);
    void deleteHotel(Integer id);
    Hotel getHotelDetailsById(Integer id);
    List<Hotel> getAllHotel();
    MessageResponse addRooms(AddRooms room, int hotelid);
    User getUserById(Integer id);
    Rooms getRoomById(Integer id);
   BookingDetails  bookRoom(BookingDetails  bookingDetails);


    Hotel getAvailableRooms(BookHotelRoom bookHotelRoom);
     BookingDetails getBookingDetails(BookRoom bookroom) ;
}
