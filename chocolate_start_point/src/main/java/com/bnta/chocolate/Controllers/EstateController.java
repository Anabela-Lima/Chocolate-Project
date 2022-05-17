package com.bnta.chocolate.Controllers;

import com.bnta.chocolate.Services.EstateService;
import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstateController {


    // methods

    @Autowired
    private EstateService estateService;

    // method to get all estates
    @GetMapping("/estates")
    public  List<Estate>  getAllEstates(){
        return estateService.getAllEstates();
    }


    // method to get individual estate by id

    @GetMapping("/estates/{id}")  // so client will make a request i.e. type: localhost:8080/chocolates/id  , where id = a number of chocolate they want to get
    public Optional<Estate> getEstate(@PathVariable Long id ){
        return estateService.get(id) ;                       // our method will return an i
    }



    // A method called addEstate that allows client to create new estates
    // and add it to our database

    @PostMapping ("/createNewEstate")
    public Estate addEstate (@RequestParam String name,             // takes in a string and a country
                             @RequestParam String country){
        return estateService.saveEstate( name, country);   // calling  saveEstate method from estate service.
                                                    // Estate service willl then be responsible for adding this to the repository
                                                    // it will create a new estate with the given inputs- its almost like its passing on name and country to saveEstate method to use
    }




}
