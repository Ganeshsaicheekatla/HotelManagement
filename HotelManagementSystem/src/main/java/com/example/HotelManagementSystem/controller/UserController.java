package com.example.HotelManagementSystem.controller;

import com.example.HotelManagementSystem.entity.HotelRoom;
import com.example.HotelManagementSystem.entity.User;
import com.example.HotelManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public User registerNewUser(@RequestBody User user){

        for (User user1:getAllUsers()){
            if(user1.getEmail().equals(user.getEmail())){
                throw  new RuntimeException("User already Exist with email");
            }
        }

        return  userService.registerNewUser(user);
    }

    @GetMapping("/login/{email}")
    public User loginUser(@PathVariable String email){
        return userService.loginUser(email);
    }

    @GetMapping("/bookingBill/{userId}")
    public Long bookingBillByUser(@PathVariable Long userId){
        return  userService.bookingBillByUser(userId);
    }

    @GetMapping("/roomRegisterWithUser/{userId}")
    public List<HotelRoom> roomRegisterWithUser(@PathVariable Long userId){
        return userService.roomRegisterWithUser(userId);
    }

    @GetMapping("/userid/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }


}
