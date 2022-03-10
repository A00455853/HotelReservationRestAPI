package com.hotel.demoHotel.model;



public class AddRooms {
    private Integer Hotelid;
    private Category category;
    private String number;
    private double price;
    private int available;

    public Integer getHotelid() {
        return Hotelid;
    }

    public void setHotelid(Integer hotelid) {
        Hotelid = hotelid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
