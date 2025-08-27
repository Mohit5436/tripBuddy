package com.example.tripbuddy.transformer;

import com.example.tripbuddy.Enum.TripStatus;
import com.example.tripbuddy.dto.request.BookingRequest;
import com.example.tripbuddy.dto.response.BookingResponse;
import com.example.tripbuddy.model.Booking;
import com.example.tripbuddy.model.Cab;
import com.example.tripbuddy.model.Customer;
import com.example.tripbuddy.model.Driver;


public class BookingTransformer {

    public static Booking bookingRequestToBooking(BookingRequest bookingRequest, double perKmRate){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDistanceInKm(bookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.In_Progress)
                .billAmount(bookingRequest.getTripDistanceInKm() * perKmRate)
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver){
        return BookingResponse.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDistanceInKm(booking.getTripDistanceInKm())
                .tripStatus(booking.getTripStatus())
                .billAmount(booking.getBillAmount())
                .bookedAt(booking.getBookedAt())
                .lastUpdateAt(booking.getLastUpdateAt())
                .customer(CustomerTransformer.customerToCustomerResponse(customer))
                .cabResponse(CabTransformer.cabToCabResponse(cab, driver))
                .build();
    }


}
