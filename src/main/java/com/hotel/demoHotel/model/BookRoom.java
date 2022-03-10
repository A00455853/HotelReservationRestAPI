package com.hotel.demoHotel.model;


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
