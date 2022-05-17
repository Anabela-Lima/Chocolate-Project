package com.bnta.chocolate.Controllers;


import com.bnta.chocolate.Services.ChocolateService;
import com.bnta.chocolate.Services.EstateService;
import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class chocolateController {

    @Autowired
    private ChocolateService chocolateService;    // gluing chocolate controllerto the chocolate service (we create an instance of chocolate service)

    @Autowired
    private EstateRepository estateRepository;  // gluing chocolate controller to the estateRepository

    // method to get All chocolates
    @GetMapping("/chocolates")
    public List<Chocolate> getAllChocolates(@RequestParam (required = false) Integer percentage){

        if (percentage.equals(null)) {
            return chocolateService.getAllChocolates();
        }
        return chocolateService.getByPercentage(percentage);
    }


    // method get Chocolates by id
    @GetMapping("/chocolates/{id}")  // so client will make a request i.e. type: localhost:8080/chocolates/id  , where id = a number of chocolate they want to get
    public Optional<Chocolate> getChocolate(@PathVariable Long id ){
        return chocolateService.get(id) ;                       // our method will return an i
    }

    //Optional is primarily intended for use as a method return type where there is a clear need to represent "no result,"
    // and where using null is likely to cause errors.




    // postMapping- this allows for client to create a new chocolate and add it to the database- make sure you have created a save method in chocolate service


    @PostMapping("/CreateNewchocolate")
            public void addChocolate(@RequestParam (required= true)String ChocolateName,
                                     @RequestParam (required = true) int cocoaPercentage,
                                     @RequestParam (required = true) Long estateID){


            // calling "add chocolate" service from ChocolateService,
        // then chocolate service is the one responsible for passing it to the repository (database)
        chocolateService.addChocolate(ChocolateName, cocoaPercentage, estateRepository.getById(estateID));  } // based on id client inputted, get the estate from estaterepository


    }





