package com.example.tripbuddy.services;

import com.example.tripbuddy.dto.request.DriverRequest;
import com.example.tripbuddy.dto.response.DriverResponse;
import com.example.tripbuddy.model.Driver;
import com.example.tripbuddy.repository.DriverRepository;
import com.example.tripbuddy.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest) {
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        return DriverTransformer.driverToDriverResponse(driverRepository.save(driver));
    }
}
