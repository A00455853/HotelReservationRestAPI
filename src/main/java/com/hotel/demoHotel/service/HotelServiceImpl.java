package com.hotel.demoHotel.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hotel.demoHotel.DTO.AddRooms;
import com.hotel.demoHotel.DTO.BookHotelRoom;
import com.hotel.demoHotel.DTO.BookRoom;
import com.hotel.demoHotel.DTO.MessageResponse;
import com.hotel.demoHotel.controller.HotelController;
import com.hotel.demoHotel.dao.BookingRepository;
import com.hotel.demoHotel.dao.HotelRepository;
import com.hotel.demoHotel.dao.RoomsRepository;
import com.hotel.demoHotel.dao.UserRepository;
import com.hotel.demoHotel.exception.ResourceNotFoundException;
import com.hotel.demoHotel.model.*;
import com.hotel.demoHotel.utils.HotelUtils;
import org.apache.log4j.Logger;
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
	final static Logger logger = Logger.getLogger(HotelServiceImpl.class);
	    @Override
	    public MessageResponse createHotel(Hotel hotelreq) {
	    	hotelRepository.save(hotelreq);
	        return new MessageResponse("New Hotel created successfully");

	    }

	    @Override
	    public Optional<Hotel> updateHotel(Integer id, Hotel hotelReq)  throws ResourceNotFoundException {
	       logger.info("getting the hotel with id "+id);
	        Optional<Hotel> hotel = hotelRepository.findById(id);
	        if (hotel==null){
	        	logger.error("hotel not found with id :"+id);
	        	throw new ResourceNotFoundException("hotel", "id", id);
	        }
	        else
	        hotel.get().setHotelname(hotelReq.getHotelname());
	        hotel.get().setAddress(hotelReq.getAddress());
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

	@Override
	public Hotel getAvailableRooms(BookHotelRoom bookHotelRoom) {
	    	Hotel hotel = getHotelDetailsById(bookHotelRoom.getHotelid());

	    	List<Rooms> roomList = roomsRepository.findAvailableRooms(bookHotelRoom.getCity(),
					bookHotelRoom.getHotelid(),bookHotelRoom.getCheckindate(),
					bookHotelRoom.getCheckoutDate());
	    	hotel.setRooms(roomList);


	    	return hotel;
	}


	public BookingDetails getBookingDetails(BookRoom bookroom) {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setDate_from(HotelUtils.convertDate(bookroom.getDate_from()));
		bookingDetails.setDate_to(HotelUtils.convertDate(bookroom.getDate_to()));
		bookingDetails.setTotal_price(bookroom.getTotal_price());
		bookingDetails.setUser_id(bookroom.getUserid());
		bookingDetails.setRoom_id(bookroom.getRoom_id());
		bookingDetails.setBook_ref_num(UUID.randomUUID().toString().replace("-", ""));
		bookingDetails.setGuests(bookroom.getGuestList());
		return bookingDetails;
	}
}
