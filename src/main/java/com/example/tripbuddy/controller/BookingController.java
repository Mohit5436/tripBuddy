package com.example.tripbuddy.controller;


import com.example.tripbuddy.dto.request.BookingRequest;
import com.example.tripbuddy.dto.response.BookingResponse;
import com.example.tripbuddy.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book/customer/{customerid}")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                                   @PathVariable("customerid") int customerId){
        return bookingService.bookCab(bookingRequest, customerId);
    }

    @PutMapping("/complete/booking/{bookingId}")
    public BookingResponse completeTrip(@PathVariable("bookingId") int bookingId){
        return bookingService.completeTrip(bookingId);
    }
}
