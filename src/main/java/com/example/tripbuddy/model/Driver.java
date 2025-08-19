package com.example.tripbuddy.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    private String name;
    private int age;
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="driver_id")
    List<Booking> bookings = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cad_id")
    Cab cab;
}

