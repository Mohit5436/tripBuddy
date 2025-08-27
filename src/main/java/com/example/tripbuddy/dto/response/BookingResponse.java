package com.example.tripbuddy.dto.response;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

public class BookingResponse {

    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    private double billAmount;

    Date bookedAt;

    Date lastUpdateAt;
}
