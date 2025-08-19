package com.example.tripbuddy.model;

import com.example.tripbuddy.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor //creates default constructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private int age;
    private String emailId;

    @Enumerated(value=EnumType.STRING)
    private Gender gender;

    @OneToMany
    @JoinColumn(name = "customer_id")
    List<Booking> bookings = new ArrayList<>();


}
