package com.hotel.demoHotel.dao;

import com.hotel.demoHotel.model.Rooms;
import com.hotel.demoHotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
