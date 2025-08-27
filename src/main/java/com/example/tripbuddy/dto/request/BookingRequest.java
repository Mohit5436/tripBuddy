package com.example.tripbuddy.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingRequest {

    private String pickup;
    private String destination;
    private double tripDistanceInKm;
}
