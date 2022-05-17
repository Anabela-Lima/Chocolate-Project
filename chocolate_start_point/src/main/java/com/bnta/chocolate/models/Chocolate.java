package com.bnta.chocolate.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity                 // superpower given to class - uses hibernate under the hood which maps objects of this class to rows in
                        // relational database table
public class Chocolate {


    @Id   // indicates that member field below this annotation (i.e. id) is the primary key for this entity (i.e. the table)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // so that client doesnt have to manually put in the IDs in post (when theyre trying to add a chocoalate object to the list)
                                                        // this will be done automatically and next id numher will follow
    // properties (or "fields")
    private Long id;
    private String name;
    private int cocoaPercentage;

    @JsonBackReference  // to stop that cyclic problem of items being printing eternally
    @ManyToOne                        //relationship between chcocolate and estates = many-one : many chocolates can be in 1 estate
    private Estate estate;



    // Constructors (2)

    // Arg constructor
    public Chocolate( String name, int cocoaPercentage, Estate estate) {
        this.id = id;
        this.name = name;
        this.cocoaPercentage = cocoaPercentage;
        this.estate = estate;
    }

    // no arg constructor
    public Chocolate() {}



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

    public int getCocoaPercentage() {
        return cocoaPercentage;
    }

    public void setCocoaPercentage(int cocoaPercentage) {
        this.cocoaPercentage = cocoaPercentage;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }





}
