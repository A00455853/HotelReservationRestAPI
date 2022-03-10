package com.hotel.demoHotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="hoteldetail")
public class Hotel implements Serializable {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String hotelname;
	    private Float starrating;
	    private Integer numberOfRooms;
	    private String city;
		private String country;
		private String address;
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "hotel_id", referencedColumnName = "id")
		List< Rooms > rooms = new ArrayList< >();

		public Hotel(Integer id, String hotelname, Float starrating, Integer numberOfRooms, String city, String country, String address) {
		this.id = id;
		this.hotelname = hotelname;
		this.starrating = starrating;
		this.numberOfRooms = numberOfRooms;
		this.city = city;
		this.country = country;
		this.address = address;
	}
	public Hotel( String hotelname, Float starrating, Integer numberOfRooms, String city, String country, String address) {

		this.hotelname = hotelname;
		this.starrating = starrating;
		this.numberOfRooms = numberOfRooms;
		this.city = city;
		this.country = country;
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Hotel() {
			
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getHotelname() {
			return hotelname;
		}
		public void setHotelname(String hotelname) {
			this.hotelname = hotelname;
		}
		public Float getStarrating() {
			return starrating;
		}
		public void setStarrating(Float starrating) {
			this.starrating = starrating;
		}
		public Integer getNumberOfRooms() {
			return numberOfRooms;
		}
		public void setNumberOfRooms(Integer numberOfRooms) {
			this.numberOfRooms = numberOfRooms;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}

	public List<Rooms> getRooms() {
		return rooms;
	}

	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Hotel{" +
				"id=" + id +
				", hotelname='" + hotelname + '\'' +
				", starrating=" + starrating +
				", numberOfRooms=" + numberOfRooms +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
