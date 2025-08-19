package com.example.tripbuddy.services;

import com.example.tripbuddy.Enum.Gender;
import com.example.tripbuddy.dto.request.CustomerRequest;
import com.example.tripbuddy.dto.response.CustomerResponse;
import com.example.tripbuddy.exception.CustomerNotFoundException;
import com.example.tripbuddy.model.Customer;
import com.example.tripbuddy.repository.CustomerRepository;
import com.example.tripbuddy.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        // Request to entity conversion
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        //save
        Customer c = customerRepository.save(customer);

        //create entity to dto
        return CustomerTransformer.customerToCustomerResponse(customer);
    }


    public CustomerResponse getCustomer(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }
        Customer c = customer.get();
        return CustomerTransformer.customerToCustomerResponse(c);
    }

    public List<CustomerResponse> getAllByGender(Gender gender) {
        List<Customer> customers = customerRepository.findByGender(gender);

        //convert from customer to customer response
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer i : customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(i));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age){
        List<Customer> customers = customerRepository.findByGenderAndAge(gender, age);

        //conver form customer to customer response
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer i : customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(i));
        }
        return customerResponses;

    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getAllByGenderAndAgeGreaterThan(gender, age);

        //conver form customer to customer response
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer i : customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(i));
        }
        return customerResponses;
    }
}
