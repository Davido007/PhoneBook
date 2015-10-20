package com.gft.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ddph on 06/10/2015.
 */
@Entity
@Table (name = "number")
public class PhoneNumber {

    @Id
    private Integer id_person;
    private String prefix;
    private String number;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
