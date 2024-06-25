package com.example.HotelManagementSystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "HotelRoom")
public class HotelRoom {

    @Id
    private Long Id;

    @Column
    private String roomType;


    @Column
    private Long capacity;

    @Column
    private Long price;

    @OneToMany(mappedBy = "hotelRoom")
    @JsonIgnoreProperties("hotelRoom")
    private List<BookingRoom> bookings;



    public List<BookingRoom> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingRoom> bookings) {
        this.bookings = bookings;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }


    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
