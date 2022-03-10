package com.hotel.demoHotel.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile")
    private String mobile;

}
