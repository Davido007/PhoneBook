package com.gft.entities;

import javax.persistence.*;


/**
 * Created by ddph on 06/10/2015.
 */
@Entity
@Table(name = "address")
public class Address {

    @Id
    private Integer id;
    private String city;
    private String street;
    private String houseNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }



}
