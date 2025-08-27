package com.example.tripbuddy.repository;

import com.example.tripbuddy.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
