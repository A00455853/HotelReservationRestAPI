package com.hotel.demoHotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="bookingdetails")
public class BookingDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "ROOM_ID")
    private Rooms room_id;

    @Column(name = "date_from")
    private LocalDate date_from;

    @Column(name = "date_to")
    private LocalDate date_to;

    @Column(name = "total_price")
    private double total_price;

    public BookingDetails() {
    }

    public BookingDetails(long id, User user, Rooms room_id, LocalDate date_from, LocalDate date_to, double total_price) {
        this.id = id;
        this.user = user;
        this.room_id = room_id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.total_price = total_price;
    }
    public BookingDetails( User user, Rooms room_id, LocalDate date_from, LocalDate date_to, double total_price) {

        this.user = user;
        this.room_id = room_id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.total_price = total_price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rooms getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Rooms room_id) {
        this.room_id = room_id;
    }

    public LocalDate getDate_from() {
        return date_from;
    }

    public void setDate_from(LocalDate date_from) {
        this.date_from = date_from;
    }

    public LocalDate getDate_to() {
        return date_to;
    }

    public void setDate_to(LocalDate date_to) {
        this.date_to = date_to;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "id=" + id +
                ", user=" + user +
                ", room_id=" + room_id +
                ", date_from=" + date_from +
                ", date_to=" + date_to +
                ", total_price=" + total_price +
                '}';
    }
}
