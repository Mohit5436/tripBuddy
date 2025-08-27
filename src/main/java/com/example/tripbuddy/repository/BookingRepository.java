package com.example.tripbuddy.repository;

import com.example.tripbuddy.model.Booking;
import com.example.tripbuddy.model.Customer;
import com.example.tripbuddy.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking, Integer> {


    @Query(value = "SELECT c.* FROM customer c JOIN booking b ON c.customer_id = b.customer_id WHERE b.booking_id = :bookingId",
            nativeQuery = true)
    Customer getCustomerFromBookingId(@Param("bookingId") int bookingId);


    @Query(value = "SELECT d.* FROM driver d JOIN booking b ON d.driver_id = b.driver_id WHERE b.booking_id = :bookingId", nativeQuery = true)
    Driver getDriverFromBookingID(int bookingId);
}
