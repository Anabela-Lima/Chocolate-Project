package com.bnta.chocolate.config;


import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration   //
public class DBSeeder implements ApplicationRunner {
    // this is where you put all data

     /*
      A configuration class that implements ApplicationRunner
      Long story short - we put come code in the run method to populate the DB after Spring App is ready.
    */

    @Autowired
    private EstateRepository estateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // creating estate objects
        Estate estate1 = new Estate("UK_Estate", "UK");
        Estate estate2 = new Estate("US_Estate", "US");
        Estate estate3 = new Estate("Japan_Estate", "Japan");
        Estate estate4 = new Estate("Canada_Estate", "Canada");
        Estate estate5 = new Estate("France_Estate", "France");

        // creating chcolate objects
        Chocolate chocolate1 = new Chocolate( "Name1", 20, estate1);
        Chocolate chocolate2 = new Chocolate("Name2", 30, estate1);
        Chocolate chocolate3 = new Chocolate("Name3", 39, estate2);
        Chocolate chocolate4 = new Chocolate("Name4", 100, estate2);
        Chocolate chocolate5 = new Chocolate("Name5", 50, estate3);
        Chocolate chocolate6 = new Chocolate("Name6", 45, estate3);
        Chocolate chocolate7 = new Chocolate("Name7", 21, estate4);
        Chocolate chocolate8 = new Chocolate("Name8", 10, estate4);
        Chocolate chocolate9 = new Chocolate("Name9", 58, estate5);
        Chocolate chocolate10 = new Chocolate("Name10", 30, estate5);


        // estates have a list of chocolcate
        estate1.setChocolates(List.of(chocolate1, chocolate2));
        estate2.setChocolates(List.of(chocolate3, chocolate4));
        estate3.setChocolates(List.of(chocolate5, chocolate6));
        estate4.setChocolates(List.of(chocolate7, chocolate8));
        estate5.setChocolates(List.of(chocolate9, chocolate10));

        estateRepository.saveAll(List.of(estate1, estate2, estate3, estate4, estate5));
    }




}
