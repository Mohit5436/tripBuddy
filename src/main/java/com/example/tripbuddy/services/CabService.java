package com.example.tripbuddy.services;

import com.example.tripbuddy.dto.request.CabRequest;
import com.example.tripbuddy.dto.response.CabResponse;
import com.example.tripbuddy.exception.DriverNotFoundException;
import com.example.tripbuddy.model.Cab;
import com.example.tripbuddy.model.Driver;
import com.example.tripbuddy.repository.DriverRepository;
import com.example.tripbuddy.transformer.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {

    @Autowired
    DriverRepository driverRepository;

    public CabResponse registerCab(CabRequest cabRequest, int driverId) {
        // verify the driver
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Invalid Drvier Id!!");
        }

        Driver driver = optionalDriver.get();
        Cab cab = CabTransformer.cabRequestToCab(cabRequest);
        driver.setCab(cab);

        Driver savedDriver =driverRepository.save(driver);

        return CabTransformer.cabToCabResponse(savedDriver.getCab(), savedDriver);
    }
}
