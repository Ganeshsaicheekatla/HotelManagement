package com.example.HotelManagementSystem.controller;

import com.example.HotelManagementSystem.entity.HotelRoom;
import com.example.HotelManagementSystem.entity.User;
import com.example.HotelManagementSystem.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@CrossOrigin
public class HotelRoomController {

    @Autowired
    HotelRoomService hotelRoomService;

    @GetMapping("/registeredRooms/allRooms")
    public List<HotelRoom> allRegisteredRooms(){
        return hotelRoomService.allRegisteredRooms();
    }

    @GetMapping("/hotelId/{hotelId}")
    public HotelRoom getHotelById(@PathVariable Long hotelId){
        return hotelRoomService.getHotelById(hotelId);
    }

    @GetMapping("/roomRegisterByUser/{hotelId}")
    public List<User> roomRegisterByUser(@PathVariable Long hotelId){
        return hotelRoomService.roomRegisterByUser(hotelId);
    }



}
