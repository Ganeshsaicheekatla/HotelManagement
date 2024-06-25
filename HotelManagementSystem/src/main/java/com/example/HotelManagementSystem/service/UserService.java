package com.example.HotelManagementSystem.service;

import com.example.HotelManagementSystem.dal.UserDAL;
import com.example.HotelManagementSystem.entity.HotelRoom;
import com.example.HotelManagementSystem.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAL userDAL;

    @Transactional
    public User registerNewUser(User user) {
        return userDAL.registerNewUser(user);
    }


    @Transactional
    public User loginUser(String email) {
       User user =userDAL.loginUser(email);
       if (user == null){
           throw new RuntimeException("User with email not founded"+email);
       }
       return user;
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDAL.getAllUsers();
    }

    @Transactional
    public Long bookingBillByUser(Long userId) {
        return userDAL.bookingBillByUser(userId);
    }

    @Transactional
    public List<HotelRoom> roomRegisterWithUser(Long userId) {
        List<HotelRoom> hotelRooms= userDAL.roomRegisterWithUser(userId);

        if(ObjectUtils.isEmpty(getUserById(userId))){
            throw new RuntimeException("No user founded with user id"+userId);
        }
        if (ObjectUtils.isEmpty(hotelRooms)){
            throw  new RuntimeException("No Booking are ther for given user id"+userId);
        }

        return hotelRooms;
    }

    @Transactional
    public User getUserById(Long userId) {
        return userDAL.getUserById(userId);
    }
}
