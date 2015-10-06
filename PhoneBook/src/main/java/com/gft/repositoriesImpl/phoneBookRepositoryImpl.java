package com.gft.repositoriesImpl;

import com.gft.entities.Address;
import com.gft.entities.PhoneNumber;
import com.gft.entities.Record;
import com.gft.repositories.phoneBookRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddph on 06/10/2015.
 */
public class phoneBookRepositoryImpl implements phoneBookRepository {
    public List<Record> getRecordByFullName(String fullName) {
        Record record = new Record();
        record.setFirstName(fullName);
        record.setSurname("Adamowski");
        Address address = new Address();
        address.setCity("Lleida");
        address.setHouseNumber("22a");
        address.setStreet("el General");
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPrefix("+48");
        phoneNumber.setNumber("123 123 123");
        record.setAddress(address);
        record.setPhoneNumber(phoneNumber);
        List<Record> records = new ArrayList<Record>();
        records.add(record);
        return records;
    }

    public List<Record> getRecordByPrefix(String prefix) {
        Record record = new Record();
        record.setFirstName("Karol");
        record.setSurname("Adamowski");
        Address address = new Address();
        address.setCity("Lleida");
        address.setHouseNumber("22a");
        address.setStreet("el General");
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPrefix(prefix);
        phoneNumber.setNumber("123 123 123");
        record.setAddress(address);
        record.setPhoneNumber(phoneNumber);
        List<Record> records = new ArrayList<Record>();
        records.add(record);
        return records;
    }

    public List<Record> getAllRecords() {
        Record record = new Record();
        record.setFirstName("Andrzej");
        record.setSurname("Kowalski");
        Address address = new Address();
        address.setCity("Lleida");
        address.setHouseNumber("22a");
        address.setStreet("el General");
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPrefix("+48");
        phoneNumber.setNumber("123 123 123");
        record.setAddress(address);
        record.setPhoneNumber(phoneNumber);
        List<Record> records = new ArrayList<Record>();
        records.add(record);
        return records;
    }
}
