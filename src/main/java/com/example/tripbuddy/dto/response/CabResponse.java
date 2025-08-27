package com.example.tripbuddy.dto.response;


import lombok.*;

@NoArgsConstructor //creates default constructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {

    private String cabNumber;
    private String cabModel;
    private double perKmRate;
    private boolean available;
    private DriverResponse driver;
}
