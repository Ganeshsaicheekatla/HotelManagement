package com.example.HotelManagementSystem.dal;

import com.example.HotelManagementSystem.entity.BookingRoom;
import com.example.HotelManagementSystem.entity.HotelRoom;
import com.example.HotelManagementSystem.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDALImp implements UserDAL{

    @Autowired
    EntityManager entityManager;



    @Override
    public User registerNewUser(User user) {
        Session session = entityManager.unwrap(Session.class);

        Serializable userID = (Serializable) session.save(user);

       return userID!=null ? user : null;

    }

    @Override
    public List<User> getAllUsers() {

        Session session = entityManager.unwrap(Session.class);

        String hql  = "select u from User u";

        Query query = session.createQuery(hql , User.class);

        return  query.getResultList();
    }


    @Override
    public User getUserById(Long userId) {
        Session session = entityManager.unwrap(Session.class);
        return  session.get(User.class , userId);
    }




    @Override
    public User loginUser(String email) {

        Session session = entityManager.unwrap(Session.class);

        try {


        String hql  = "select u from User u where u.email =:email";

        Query query = session.createQuery(hql , User.class);

        query.setParameter("email", email);

        User user1 = (User) query.getSingleResult();

        return user1;
        }
        catch (Exception e){
                throw new RuntimeException("Email not founded");
        }
    }

    @Override
    public Long bookingBillByUser(Long userId) {

       User user = getUserById(userId);
       long totalBill = 0;

       for (BookingRoom bookingRoom : user.getBookingRooms()){
           totalBill += bookingRoom.getHotelRoom().getPrice();
       }

        return totalBill;
    }

    @Override
    public List<HotelRoom> roomRegisterWithUser(Long userId) {

        User user = getUserById(userId);

        Set<HotelRoom> hotelRooms =new HashSet<HotelRoom>();

        for (BookingRoom bookingRoom : user.getBookingRooms()){
            hotelRooms.add(bookingRoom.getHotelRoom());
        }

        return new ArrayList<>(hotelRooms);

    }


}
