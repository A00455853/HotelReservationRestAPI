package com.hotel.demoHotel.controller;

import java.util.List;
import java.util.Optional;

import com.hotel.demoHotel.model.Hotel;
import com.hotel.demoHotel.model.MessageResponse;
import com.hotel.demoHotel.service.HotelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/hoteldemo")
public class HotelController {
	
	  @Autowired
      HotelService hotelService;
    final static Logger logger = Logger.getLogger(HotelController.class);
	  
	@GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotelDetails () {
        logger.info("GET: All Hotel list");
        List<Hotel> hotelList = hotelService.getAllHotel();
        return new ResponseEntity<>(hotelList, HttpStatus.OK);
    }
	
	@GetMapping("/find/{id}")
    public ResponseEntity<Hotel> getHotelDetailsById (@PathVariable("id") Integer id) {
        logger.info("GET: getting the hotel details with id :"+id);
        Hotel hotel = hotelService.getHotelDetailsById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addHotel(@RequestBody Hotel hotel) {
        logger.info("POST: adding new hotel to database with name:"+hotel.getHotelname());
        MessageResponse hotelCreated = hotelService.createHotel(hotel);
        return new ResponseEntity<>(hotelCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Optional<Hotel> updateHotel(@PathVariable Integer id, @RequestBody Hotel hotel) {
        logger.info("PUT: update hotel details for hotel :"+hotel.getHotelname());
        return hotelService.updateHotel(id, hotel);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable("id") Integer id) {
        logger.info("Delete : delete hotel details for  hotelid:"+id);
    	hotelService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
