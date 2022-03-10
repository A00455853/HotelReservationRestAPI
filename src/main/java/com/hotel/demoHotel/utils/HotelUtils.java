package com.hotel.demoHotel.utils;

import java.time.LocalDate;

public class HotelUtils {

    public static LocalDate convertDate(String date){

        LocalDate aLD = LocalDate.parse(date);
        System.out.println("Date: " + aLD);
        return aLD;
    }
}
