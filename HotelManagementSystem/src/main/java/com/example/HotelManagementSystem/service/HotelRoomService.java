package com.example.HotelManagementSystem.service;

import com.example.HotelManagementSystem.dal.HotelRoomDAL;
import com.example.HotelManagementSystem.entity.HotelRoom;
import com.example.HotelManagementSystem.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelRoomService {

    @Autowired
    HotelRoomDAL hotelRoomDAL;



    @Transactional
    public List<HotelRoom> allRegisteredRooms() {
        return hotelRoomDAL.allRegisteredRooms();
    }


    @Transactional
    public HotelRoom getHotelById(Long hotelId) {
       return hotelRoomDAL.getHotelById(hotelId);
    }


    @Transactional
    public List<User> roomRegisterByUser(Long hotelId) {
        return hotelRoomDAL.roomRegisterByUser(hotelId);
    }
}
