package com.example.tripbuddy.transformer;

import com.example.tripbuddy.dto.request.CabRequest;
import com.example.tripbuddy.dto.response.CabResponse;
import com.example.tripbuddy.model.Cab;
import com.example.tripbuddy.model.Driver;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .cabModel(cabRequest.getCabModel())
                .perKmRate(cabRequest.getPerKmRate())
                .available(true)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab, Driver driver){
        return CabResponse.builder()
                .cabNumber(cab.getCabNumber())
                .perKmRate(cab.getPerKmRate())
                .cabModel(cab.getCabModel())
                .available(cab.isAvailable())
                .driver(DriverTransformer.driverToDriverResponse(driver))
                .build();
    }
}
