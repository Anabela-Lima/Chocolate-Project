package com.bnta.chocolate.Services;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstateService {

    @Autowired    // gluing estate service to estate repository
    private EstateRepository estateRepository;

    // service method called 'getAllEstates' to return List of estate objects
    public List<Estate> getAllEstates(){
        return estateRepository.findAll();
    }



    // service method called "get", it returns an estate
    public Optional<Estate> get(Long id) {
        return estateRepository.findById(id);
    }



    // Service method called "add" for client to create new estate and add it to our database

    public Estate saveEstate(String name, String country) {  // takes in an estate
        return estateRepository.save( new Estate(name, country));   // saves the new estate in estateRepository which connects to our database
    }


}


