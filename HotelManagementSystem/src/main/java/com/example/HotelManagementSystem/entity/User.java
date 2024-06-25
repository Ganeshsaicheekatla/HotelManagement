package com.example.HotelManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int Id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<BookingRoom> bookingRooms;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public List<BookingRoom> getBookingRooms() {
        return bookingRooms;
    }

    public void setBookingRooms(List<BookingRoom> bookingRooms) {
        this.bookingRooms = bookingRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
