package com.example.tripbuddy.dto.response;

import lombok.*;


@NoArgsConstructor //creates default constructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {

    private String name;
    private int age;
    private String emailId;

}
