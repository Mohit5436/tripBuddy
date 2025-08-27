package com.example.tripbuddy.controller;


import com.example.tripbuddy.dto.request.CabRequest;
import com.example.tripbuddy.dto.response.CabResponse;
import com.example.tripbuddy.services.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    CabService cabService;

    @PostMapping("/register/driver/{driverId}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest, @PathVariable("driverId") int driverId){
        return cabService.registerCab(cabRequest, driverId);
    }
}
