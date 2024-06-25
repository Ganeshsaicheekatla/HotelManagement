package com.example.HotelManagementSystem.controller;


import com.example.HotelManagementSystem.entity.BookingRoom;

import com.example.HotelManagementSystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookingRoom")
@CrossOrigin
public class BookingRoomController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/bookroomToUser/{userId}")
    public BookingRoom registerRoomToUser(@PathVariable Long userId , @RequestBody BookingRoom bookingRoom){
        return bookingService.registerRoomToUser(userId , bookingRoom);
    }

    @GetMapping("/allBookings")
    public List<BookingRoom> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/id/{id}")
    public BookingRoom getBookingRoomById(@PathVariable Long id){
        return bookingService.getBookingRoomById(id);
    }

    @GetMapping("/user/{userId}")
    public List<BookingRoom> getBookingsByUserID(@PathVariable Long userId){
        return  bookingService.getBookingsByUserID(userId);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<BookingRoom> getBookingsByHotelId(@PathVariable Long hotelId){
        return  bookingService.getBookingsByHotelId(hotelId);
    }

}
