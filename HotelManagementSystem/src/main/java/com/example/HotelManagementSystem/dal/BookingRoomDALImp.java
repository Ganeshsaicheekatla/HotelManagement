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

    import java.util.ArrayList;
    import java.util.List;


    @Repository
    public class BookingRoomDALImp implements BookingRoomDAL{

        @Autowired
        EntityManager entityManager;

        @Autowired
        UserDAL userDAL;

        @Autowired
        HotelRoomDAL hotelRoomDAL;


        public long checkAvalibilityByType(String roomType , BookingRoom bookingRoom){

            int startId = 0 , endInd = 0;

            if(roomType.equalsIgnoreCase("Normal")){
                startId = 1;
                endInd = 10;
            }
            else if(roomType.equalsIgnoreCase("premium")){
                startId = 10;
                endInd = 20;
            }
            else {
                startId = 21;
                endInd = 30;
            }

            Session session = entityManager.unwrap(Session.class);
            String hql = "SELECT b FROM BookingRoom b JOIN b.hotelRoom h WHERE h.id = :id AND "+
                    "(b.startDate < :endDate AND b.endDate > :startDate)";

            Query query = session.createQuery(hql,BookingRoom.class);

            for (int i = startId ; i <= endInd ; i++){


                query.setParameter("startDate",bookingRoom.getStartDate());
                query.setParameter("endDate",bookingRoom.getEndDate());
                query.setParameter("id", i);

                List<BookingRoom> bookingRoomList =query.getResultList();

                if(ObjectUtils.isEmpty(bookingRoomList))
                     return i;

            }

            return -1;
        }


        @Override
        public BookingRoom registerRoomToUser(Long userId, BookingRoom bookingRoom) {

            String roomType = bookingRoom.getHotelRoom().getRoomType();
            long hotelId = checkAvalibilityByType( roomType , bookingRoom);
            bookingRoom.setBookingStatus("Accepted");

            if(hotelId == -1){
                if(roomType.equalsIgnoreCase("Normal")){
                    hotelId = (long) (Math.random() * 11) + 1;
                }
                else if(roomType.equalsIgnoreCase("premium")){
                    hotelId = (long) (Math.random() * 11) + 10;
                }
                else {
                    hotelId = (long) (Math.random() * 11) + 20;
                }

                bookingRoom.setBookingStatus("Rejected");

            }

            bookingRoom.getHotelRoom().setId(hotelId);


//            getting user and hotel Details
            User user = userDAL.getUserById(userId);
            HotelRoom hotelRoom1 = hotelRoomDAL.saveHotel(bookingRoom.getHotelRoom());

//            setting to booking details
            bookingRoom.setUser(user);
            bookingRoom.setHotelRoom(hotelRoom1);

            if(user.getBookingRooms() == null){
                user.setBookingRooms(new ArrayList<>());
            }

            user.getBookingRooms().add(bookingRoom);

            if (hotelRoom1.getBookings() == null){
                hotelRoom1.setBookings(new ArrayList<>());
            }


            hotelRoom1.getBookings().add(bookingRoom);

//            updating the details to user and hotelRoom1
            Session session = entityManager.unwrap(Session.class);

            session.update(user);
            session.update(hotelRoom1);



//          saving the booking details
            session.save(bookingRoom);

            return bookingRoom;

        }

        @Override
        public List<BookingRoom> getAllBookings() {

            Session session = entityManager.unwrap(Session.class);

            String hql = "select b from BookingRoom b ";

            Query query  = session.createQuery(hql , BookingRoom.class);

            return  query.getResultList();


        }

        @Override
        public BookingRoom getBookingRoomById(Long id) {
            Session session = entityManager.unwrap(Session.class);

            return session.get(BookingRoom.class , id);
        }

        @Override
        public List<BookingRoom> getBookingsByUserID(Long userId) {
            Session session = entityManager.unwrap(Session.class);

            String hql = "select b from BookingRoom b join b.user u where u.id = :id";

            Query query  = session.createQuery(hql , BookingRoom.class);

            query.setParameter("id",userId);

            return  query.getResultList();
        }

        @Override
        public List<BookingRoom> getBookingsByHotelId(Long hotelId) {

            Session session = entityManager.unwrap(Session.class);

            String hql = "select b from BookingRoom b join b.hotelRoom h where h.Id = :id";

            Query query  = session.createQuery(hql , BookingRoom.class);

            query.setParameter("id",hotelId);

            return  query.getResultList();

        }


    }
