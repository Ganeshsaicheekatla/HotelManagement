package com.example.HotelManagementSystem.service;

import com.example.HotelManagementSystem.dal.BookingRoomDAL;
import com.example.HotelManagementSystem.entity.BookingRoom;
import com.example.HotelManagementSystem.entity.HotelRoom;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRoomDAL bookingRoomDAL;

    @Transactional
    public BookingRoom registerRoomToUser(Long userId, BookingRoom bookingRoom) {
        return bookingRoomDAL.registerRoomToUser(userId , bookingRoom);
    }

    @Transactional
    public List<BookingRoom> getAllBookings() {
        List<BookingRoom> bookingRooms= bookingRoomDAL.getAllBookings();

        if(ObjectUtils.isEmpty(bookingRooms)){
            throw  new RuntimeException("Not bookings till now");
        }
        return bookingRooms;
    }

    @Transactional
    public BookingRoom getBookingRoomById(Long id) {
        BookingRoom bookingRoom= bookingRoomDAL.getBookingRoomById(id);
        if(bookingRoom == null){
            throw  new RuntimeException("Not booking founded with id"+id);
        }
        return  bookingRoom;
    }

    @Transactional
    public List<BookingRoom> getBookingsByUserID(Long userId) {
        List<BookingRoom> bookingRooms= bookingRoomDAL.getBookingsByUserID(userId);
        if (ObjectUtils.isEmpty(bookingRooms)){
            throw new RuntimeException("No booking with user id"+userId);
        }
        return bookingRooms;
    }

    @Transactional
    public List<BookingRoom> getBookingsByHotelId(Long hotelId) {
        return bookingRoomDAL.getBookingsByHotelId(hotelId);
    }
}
