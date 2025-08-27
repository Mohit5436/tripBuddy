package com.example.tripbuddy.dto.response;

import com.example.tripbuddy.Enum.TripStatus;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {

    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    private double billAmount;

    TripStatus tripStatus;
    Date bookedAt;

    Date lastUpdateAt;
    CustomerResponse customer;
    CabResponse cabResponse;
}
