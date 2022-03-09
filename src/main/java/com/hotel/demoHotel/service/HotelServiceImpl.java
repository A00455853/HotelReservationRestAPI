package com.hotel.demoHotel.service;

import java.util.List;
import java.util.Optional;

import com.hotel.demoHotel.dao.HotelRepository;
import com.hotel.demoHotel.exception.ResourceNotFoundException;
import com.hotel.demoHotel.model.Hotel;
import com.hotel.demoHotel.model.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HotelServiceImpl implements HotelService{

	
	    
	    @Autowired
		HotelRepository hotelRepository;

	    @Override
	    public MessageResponse createHotel(Hotel hotelreq) {
	        Hotel hotel = new Hotel();
	        hotel.setHotelname(hotelreq.getHotelname());
	        hotel.setAddress(hotelreq.getAddress());
	        hotel.setNumberOfRooms(hotelreq.getNumberOfRooms());
	        hotel.setStarrating(hotelreq.getStarrating());
	       
	        hotelRepository.save(hotel);
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
}
