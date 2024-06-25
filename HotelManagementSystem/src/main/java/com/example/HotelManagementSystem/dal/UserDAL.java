package com.example.HotelManagementSystem.dal;

import com.example.HotelManagementSystem.entity.HotelRoom;
import com.example.HotelManagementSystem.entity.User;

import java.util.List;

public interface UserDAL {

    User loginUser(String email) ;

    User registerNewUser(User user);

    List<User> getAllUsers();

    User getUserById(Long userId);

    Long bookingBillByUser(Long userId);

    List<HotelRoom> roomRegisterWithUser(Long userId);
}
