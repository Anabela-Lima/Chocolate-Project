package com.bnta.chocolate.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estate {

    @Id   // indicates that member field below this annotation (i.e. id) is the primary key for this entity (i.e. the table)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // so that client doesnt have to manually put in the IDs in post (when theyre trying to add a chocoalate object to the list)
                                                        // this will be done automatically and next id numher will follow
                                                        // properties (or "fields")
  // properties or ("fields"
    private Long id;
    private String name;
    private String country;


    @JsonManagedReference   // stops infinite looping
     @OneToMany(mappedBy = "estate", cascade = CascadeType.ALL)     //relationship between chcocolate and estates = one-many : 1 estate can have many chocolates
                                                                    // this "cascade" variable allows us to save a list of chocolate objects, named "chocolate"
    private List<Chocolate> chocolates;                             // and assign it to an estate
                                                     // note: this  "private List<Chocolate> chocolates;  "  is
                                                    // just another property like the ones above
                                                    //  only difference we defined a relationship
                                                    // between this property and the estate table

   // Constructors (2)

    // Arg constructor

    public Estate( String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.chocolates = new ArrayList<Chocolate>();
    }

    // No Arg constructor
    public Estate() {
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Chocolate> getChocolates() {
        return chocolates;
    }

    public void setChocolates(List<Chocolate> chocolates) {
        this.chocolates = chocolates;
    }



}
