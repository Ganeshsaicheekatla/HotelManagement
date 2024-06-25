package com.example.HotelManagementSystem.dal;

import com.example.HotelManagementSystem.entity.HotelRoom;
import com.example.HotelManagementSystem.entity.User;

import java.util.List;

public interface HotelRoomDAL {

    HotelRoom saveHotel(HotelRoom hotelRoom);


    List<HotelRoom> allRegisteredRooms();


    HotelRoom getHotelById(Long hotelId);

    List<User> roomRegisterByUser(Long hotelId);
}
