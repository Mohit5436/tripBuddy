package com.example.tripbuddy.repository;

import com.example.tripbuddy.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {
}
