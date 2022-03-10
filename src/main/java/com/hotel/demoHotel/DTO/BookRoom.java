package com.hotel.demoHotel.DTO;


import com.hotel.demoHotel.model.Guest;
import lombok.Data;

import java.util.List;

@Data
public class BookRoom {
    private Integer room_id;
    private Integer userid;
    private String date_from;
    private String date_to;
    private double total_price;
    private List<Guest> guestList;

}
