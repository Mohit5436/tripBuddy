package com.example.tripbuddy.transformer;

import com.example.tripbuddy.dto.request.CustomerRequest;
import com.example.tripbuddy.dto.response.CustomerResponse;
import com.example.tripbuddy.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setGender(customerRequest.getGender());
//        customer.setEmailId(customerRequest.getEmailId());
        return Customer.builder().name(customerRequest.getName()).age(customerRequest.getAge()).gender(customerRequest.getGender()).emailId(customerRequest.getEmailId()).build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
//        CustomerResponse cr = new CustomerResponse();
//        cr.setName(customer.getName());
//        cr.setAge(customer.getAge());
//        cr.setEmailId(customer.getEmailId());
        CustomerResponse cr = CustomerResponse.builder().name(customer.getName()).age(customer.getAge()).emailId(customer.getEmailId()).build();
        return cr;

    }
}
