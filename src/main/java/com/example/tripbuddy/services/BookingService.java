package com.example.tripbuddy.services;


import com.example.tripbuddy.Enum.TripStatus;
import com.example.tripbuddy.dto.request.BookingRequest;
import com.example.tripbuddy.dto.response.BookingResponse;
import com.example.tripbuddy.exception.CabUnavailableException;
import com.example.tripbuddy.exception.CustomerNotFoundException;
import com.example.tripbuddy.exception.InvalidBookingId;
import com.example.tripbuddy.model.Booking;
import com.example.tripbuddy.model.Cab;
import com.example.tripbuddy.model.Customer;
import com.example.tripbuddy.model.Driver;
import com.example.tripbuddy.repository.BookingRepository;
import com.example.tripbuddy.repository.CabRepository;
import com.example.tripbuddy.repository.CustomerRepository;
import com.example.tripbuddy.repository.DriverRepository;
import com.example.tripbuddy.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    BookingRepository bookingRepository;




    public BookingResponse bookCab(BookingRequest bookingRequest, int customerId) {

        //check weather customer exists or not
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }

        Customer customer = optionalCustomer.get();

        //get random cab

        Cab availableCab  = cabRepository.getAvailableCabRandomly();
        if(availableCab == null) throw new CabUnavailableException("Sorry! No cab available");


        // if cab is available initialize booking
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest, availableCab.getPerKmRate());
        Booking savedBooking = bookingRepository.save(booking);
        availableCab.setAvailable(false);
        customer.getBookings().add(savedBooking);

        // reflect booking on driver as well as customer

        Driver driver = driverRepository.getDriverByCabId(availableCab.getCabId());
        driver.getBookings().add(savedBooking);

        Customer savedCustomer = customerRepository.save(customer);
        Driver savedDriver = driverRepository.save(driver);

        return BookingTransformer.bookingToBookingResponse(savedBooking,savedCustomer, availableCab, savedDriver);

    }

    public BookingResponse completeTrip(int bookingId) {
        // Check weather the booking id is legit or not
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if(optionalBooking.isEmpty()) throw new InvalidBookingId("Entered Booking Id is Invalid!!!");

        Booking completedBooking = optionalBooking.get();
        completedBooking.setTripStatus(TripStatus.Complete);
        bookingRepository.save(completedBooking);
        Customer customer = bookingRepository.getCustomerFromBookingId(bookingId);
        Driver driver = bookingRepository.getDriverFromBookingID(bookingId);
        Cab cab = driver.getCab();
        cab.setAvailable(true);
        return BookingTransformer.bookingToBookingResponse(completedBooking, customer, cab, driver);
    }
}
