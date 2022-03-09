package com.hotel.demoHotel.model;

import javax.persistence.*;

@Entity
@Table(name="hotel")
public class Hotel {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    private String hotelname;
	    private Float starrating;
	    private Integer numberOfRooms;
	    private String address;
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
		@Override
		public String toString() {
			return "Hotel [id=" + id + ", hotelname=" + hotelname + ", starrating=" + starrating + ", numberOfRooms="
					+ numberOfRooms + ", address=" + address + "]";
		}
	    
		
	

}
