package com.example.tripbuddy.repository;


import com.example.tripbuddy.Enum.Gender;
import com.example.tripbuddy.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByGender(Gender gender);

    List<Customer> findByGenderAndAge(Gender gender, int age);

    @Query("Select c from Customer c where c.gender = :gender and c.age > :age")
    List<Customer> getAllByGenderAndAgeGreaterThan(@Param("gender") Gender gender, @Param("age") int age);

    // we can write the same above query in sql as
//    @Query("Select * from Customer where gender = :gender and age > :age")
//    List<Customer> getAllByGenderAndAgeGreaterThan(@Param("gender") String gender, @Param("age") int age);


}
