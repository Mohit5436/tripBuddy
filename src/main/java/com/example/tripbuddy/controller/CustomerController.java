package com.example.tripbuddy.controller;

import com.example.tripbuddy.Enum.Gender;
import com.example.tripbuddy.dto.request.CustomerRequest;
import com.example.tripbuddy.dto.response.CustomerResponse;
import com.example.tripbuddy.model.Customer;
import com.example.tripbuddy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse c = customerService.addCustomer(customerRequest);
        if (c == null)
            return new ResponseEntity("Database Error", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity(c, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customer_id){
        return customerService.getCustomer(customer_id);
    }

    @GetMapping("/gender/{gender}")
    public List<CustomerResponse> getAllByGender(@PathVariable("gender") Gender gender){
        return customerService.getAllByGender(gender);
    }

    @GetMapping("/get")
    public List<CustomerResponse> getAllByGenderAndAge(@RequestParam("gender") Gender gender,
                                                       @RequestParam("age") int age){
        return customerService.getAllByGenderAndAge(gender,age);
    }

    @GetMapping("/get-by-age-greater")
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(@RequestParam("gender") Gender gender, @RequestParam("age") int age){
        return customerService.getAllByGenderAndAgeGreaterThan(gender, age);
    }

}
