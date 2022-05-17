package com.bnta.chocolate.Services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired   // gluing ChocolateService with ChocolateRepository by creating an instance (object of type Chcolate Repository in ChocolateService)
    private ChocolateRepository chocolateRepository;

    public ChocolateService() {}

    // a service method  "getAllChocolates" to display list of cHCOLATES
    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();  // our method will return  all chocolates
    }

    // A service method to display chocolate by id

    public Optional <Chocolate> get(Long id){
        return chocolateRepository.findById(id);
    }


    // Service method to add chocolate


    public void addChocolate(String chocolateName, int cocoaPercentage, Estate estate) {
        chocolateRepository.save(new Chocolate(chocolateName,cocoaPercentage,estate));
    }

    // a service method to save the chocolate added by client to our database

    public Chocolate save(Chocolate chocolate) { // method returns a object of type Chcocolate, takes in object of type Choaocalte called "chocolate"

        // add some extra logic
        return chocolateRepository.save(chocolate);   // save the client chocolate in chocolate repository which connects to our database
    }


    // connecting query to controller


    public List<Chocolate> getByPercentage(Integer percentage) {  //client will put in a percentage value

        return chocolateRepository.cocoaGreaterThan(percentage);  // we will return all chocolates from chocolate repository where cocoa >= the given percentage by client

    }
}
