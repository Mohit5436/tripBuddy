package com.example.tripbuddy.repository;

import com.example.tripbuddy.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
