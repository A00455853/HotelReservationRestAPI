package com.hotel.demoHotel.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name="hoteldetail")
public class Hotel implements Serializable {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    private String hotelname;
	    private Float starrating;
	    private String city;
		private String country;
		private String address;
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "hotel_id", referencedColumnName = "id")
		List< Rooms > rooms = new ArrayList< >();



	@Override
	public String toString() {
		return "Hotel{" +
				"id=" + id +
				", hotelname='" + hotelname + '\'' +
				", starrating=" + starrating +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
