package com.hotel.demoHotel.dao;

import com.hotel.demoHotel.model.Hotel;
import com.hotel.demoHotel.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomsRepository extends JpaRepository<Rooms,Integer> {

    @Query(nativeQuery=true, value ="select * from hotelroom r join hoteldetail h on h.id = r.hotel_id where h.city= :city and h.id=:hotelid and r.id not in (select b.room_id from bookingdetails b where STR_TO_DATE(:fromdate,'%Y-%m-%d') BETWEEN b.date_from AND b.date_to and STR_TO_DATE(:todate,'%Y-%m-%d') BETWEEN b.date_from AND b.date_to)")
    List<Rooms> findAvailableRooms(@Param("city") String city, @Param("hotelid") int hotelid, @Param("fromdate") String fromdate, @Param("todate") String todate);
}
