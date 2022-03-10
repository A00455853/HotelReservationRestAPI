package com.hotel.demoHotel.service;

import java.util.List;
import java.util.Optional;

import com.hotel.demoHotel.dao.BookingRepository;
import com.hotel.demoHotel.dao.HotelRepository;
import com.hotel.demoHotel.dao.RoomsRepository;
import com.hotel.demoHotel.dao.UserRepository;
import com.hotel.demoHotel.exception.ResourceNotFoundException;
import com.hotel.demoHotel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HotelServiceImpl implements HotelService{

	
	    
	    @Autowired
		HotelRepository hotelRepository;
		@Autowired
		RoomsRepository roomsRepository;
		@Autowired
		UserRepository userRepository;
		@Autowired
		BookingRepository bookingRepository;

	    @Override
	    public MessageResponse createHotel(Hotel hotelreq) {
	        Hotel hotel = new Hotel();
	        hotel.setHotelname(hotelreq.getHotelname());
	        hotel.setAddress(hotelreq.getAddress());
	        hotel.setNumberOfRooms(hotelreq.getNumberOfRooms());
	        hotel.setStarrating(hotelreq.getStarrating());

	       
	        hotelRepository.save(hotelreq);
	        return new MessageResponse("New Hotel created successfully");

	    }

	    @Override
	    public Optional<Hotel> updateHotel(Integer id, Hotel hotelReq)  throws ResourceNotFoundException {
	        Optional<Hotel> hotel = hotelRepository.findById(id);
	        if (hotel==null){
	        throw new ResourceNotFoundException("hotel", "id", id);
	        }
	        else
	        hotel.get().setHotelname(hotelReq.getHotelname());
	        hotel.get().setAddress(hotelReq.getAddress());
	        hotel.get().setNumberOfRooms(hotelReq.getNumberOfRooms());
	        hotel.get().setStarrating(hotelReq.getStarrating());
	     
	        hotelRepository.save(hotel.get());
	        return hotel;
	    }

	    @Override
	    public Hotel getHotelDetailsById(Integer id) throws ResourceNotFoundException{
	        return hotelRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", id));
	    }

	    @Override
	    public List<Hotel> getAllHotel() {
	        return hotelRepository.findAll();
	    }



	@Override
	    public void deleteHotel(Integer id) throws ResourceNotFoundException {
	        if (hotelRepository.getById(id).getId().equals(id)){
	        	hotelRepository.deleteById(id);
	        }
	        else throw new ResourceNotFoundException("Hotel", "id", id);
	    }

	@Override
	public MessageResponse addRooms(AddRooms roomsreq, int hotelid) {

			Rooms room = new Rooms();
			room.setAvailable(roomsreq.getAvailable());
			room.setPrice(roomsreq.getPrice());
			room.setNumber(roomsreq.getNumber());
			roomsRepository.save(room);
			return new MessageResponse("New room has been added  to hotelid:"+hotelid);

	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}
	public Rooms getRoomById(Integer id) {
		return roomsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}

	@Override
	public BookingDetails bookRoom(BookingDetails bookingDetails) {
		BookingDetails bookingDetails1 =  bookingRepository.save(bookingDetails);
		return bookingDetails1;
	}
}
