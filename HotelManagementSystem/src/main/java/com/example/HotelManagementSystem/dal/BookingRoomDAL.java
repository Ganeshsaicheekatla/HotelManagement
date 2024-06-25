package com.example.HotelManagementSystem.dal;

import com.example.HotelManagementSystem.entity.BookingRoom;
import com.example.HotelManagementSystem.entity.HotelRoom;

import java.util.List;

public interface BookingRoomDAL {
    BookingRoom registerRoomToUser(Long userId, BookingRoom bookingRoom);

    List<BookingRoom> getAllBookings();

    BookingRoom getBookingRoomById(Long id);

    List<BookingRoom> getBookingsByUserID(Long userId);

    List<BookingRoom> getBookingsByHotelId(Long hotelId);
}
