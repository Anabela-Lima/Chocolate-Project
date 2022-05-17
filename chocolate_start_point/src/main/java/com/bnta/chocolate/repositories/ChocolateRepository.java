package com.bnta.chocolate.repositories;

import com.bnta.chocolate.models.Chocolate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChocolateRepository extends JpaRepository<Chocolate, Long> {
    // jpaRepository class  is what gives us access to a database and underthehood also runs Hibernate
    // which allows us to map chocolate objects to a row in the relational database table




    // Create a simple derived query to list all chocoholates with 60% or higher content

    // we always write queries in repository interface + annotate it with @Query

    @Query(value= "SELECT * FROM chocolate WHERE cocoa_Percentage >= ?1" , nativeQuery = true)   // note cant name cocoa percentage same as field name for coca, otherwise test wont rrun
    List<Chocolate>  cocoaGreaterThan(int cocoa_percentage);   // takes in a percentage value for cocoa- we will request client for this




}
