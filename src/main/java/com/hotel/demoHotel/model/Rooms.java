package com.hotel.demoHotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="rooms")
public class Rooms implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @Column(name = "number")
    private String number;

    @Column(name = "price")
    private double price;

    @Column(name = "available")
    private int available;



    public Rooms(long id, Category category, String number, double price, int available) {
        this.id = id;
        this.category = category;
        this.number = number;
        this.price = price;
        this.available = available;
    }
    public Rooms( Category category, String number, double price, int available) {
        this.category = category;
        this.number = number;
        this.price = price;
        this.available = available;
    }

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Hotel hotel;
//
//    public Hotel getHotel() {
//        return hotel;
//    }
//
//    public void setHotel(Hotel hotel) {
//        this.hotel = hotel;
//    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", category=" + category +
                ", number='" + number + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }

    public Rooms() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
