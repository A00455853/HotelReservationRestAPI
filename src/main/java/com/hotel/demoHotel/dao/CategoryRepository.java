package com.hotel.demoHotel.dao;

import com.hotel.demoHotel.model.Category;
import com.hotel.demoHotel.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
