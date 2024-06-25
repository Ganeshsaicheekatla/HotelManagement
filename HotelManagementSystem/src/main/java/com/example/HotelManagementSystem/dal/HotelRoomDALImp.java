package com.example.HotelManagementSystem.dal;

import com.example.HotelManagementSystem.entity.BookingRoom;
import com.example.HotelManagementSystem.entity.HotelRoom;
import com.example.HotelManagementSystem.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class HotelRoomDALImp  implements  HotelRoomDAL{

    @Autowired
    EntityManager entityManager;




    @Override
    public HotelRoom saveHotel(HotelRoom hotelRoom) {

        Session session = entityManager.unwrap(Session.class);

        HotelRoom hotelRoom1 = session.get(HotelRoom.class , hotelRoom.getId());
        if(hotelRoom1 != null)
             return hotelRoom1;
        session.save(hotelRoom);

        return hotelRoom;

    }


    @Override
    public List<HotelRoom> allRegisteredRooms() {
        Session session = entityManager.unwrap(Session.class);

        String hql = "select h from HotelRoom h";

        Query query = session.createQuery(hql , HotelRoom.class);

        return query.getResultList();
    }

    @Override
    public HotelRoom getHotelById(Long hotelId) {
        Session session = entityManager.unwrap(Session.class);
        HotelRoom hotelRoom = session.get(HotelRoom.class ,hotelId);
        return session.get(HotelRoom.class , hotelId);
    }

    @Override
    public List<User> roomRegisterByUser(Long hotelId) {

        HotelRoom hotelRoom = getHotelById(hotelId);
        Set<User> users = new HashSet<>();
        for (BookingRoom bookingRoom: hotelRoom.getBookings()){

            users.add(bookingRoom.getUser());
        }
        return new ArrayList<>(users);
    }


}
