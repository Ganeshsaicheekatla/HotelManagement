# HotelManagement

**HotelRoomController**
The HotelRoomController handles HTTP requests related to hotel room operations. It provides endpoints to retrieve all registered hotel rooms, get details of a specific hotel room by its ID, and get a list of users who have registered a particular hotel room.

Endpoints:

**GET /hotel/registeredRooms/allRooms**: Retrieves all registered hotel rooms.
**GET /hotel/hotelId/{hotelId}**: Retrieves details of a hotel room by its ID.
**GET /hotel/roomRegisterByUser/{hotelId}**: Retrieves a list of users who have registered a specific hotel room.


**BookingRoomController**
The BookingRoomController manages bookings for hotel rooms. It provides endpoints to book a room for a user, retrieve all bookings, get booking details by booking ID, and fetch bookings by user or hotel ID.

Endpoints:

**POST /bookingRoom/bookroomToUser/{userId}**: Registers a room to a user.
**GET /bookingRoom/allBookings**: Retrieves all bookings.
**GET /bookingRoom/id/{id}**: Retrieves booking details by booking ID.
**GET /bookingRoom/user/{userId}**: Retrieves bookings made by a specific user.
**GET /bookingRoom/hotel/{hotelId}**: Retrieves bookings made for a specific hotel.


**UserController**
The UserController handles user-related operations. It provides endpoints to retrieve all users, register a new user, login a user, calculate the booking bill for a user, and retrieve hotel rooms registered by a user.

Endpoints:

**GET /user/allUsers**: Retrieves all users.
**POST /user/register**: Registers a new user.
**GET /user/login/{email}**: Logs in a user by email.
**GET /user/bookingBill/{userId}**: Calculates the total booking bill for a user.
**GET /user/roomRegisterWithUser/{userId}**: Retrieves hotel rooms registered by a user.
**GET /user/userid/{userId}**: Retrieves user details by user ID.

