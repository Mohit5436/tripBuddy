package com.example.tripbuddy.dto.request;


import com.example.tripbuddy.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor //creates default constructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    private String name;
    private int age;
    private String emailId;
    private Gender gender;
}
