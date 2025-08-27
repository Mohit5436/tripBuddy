package com.example.tripbuddy.transformer;

import com.example.tripbuddy.dto.request.DriverRequest;
import com.example.tripbuddy.dto.response.DriverResponse;
import com.example.tripbuddy.model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){

        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .emailId(driverRequest.getEmailId())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .name(driver.getName())
                .age(driver.getAge())
                .emailId(driver.getEmailId())
                .driverId(driver.getDriverId())
                .build();
    }
}
