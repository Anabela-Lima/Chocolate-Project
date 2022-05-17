package com.bnta.chocolate.repositories;

import com.bnta.chocolate.models.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstateRepository extends JpaRepository<Estate, Long> {

    // jpaRepository class  is what gives us access to a database and underthehood also runs Hibernate
    // which allows us to map estate objects to a row in the relational database table
}
