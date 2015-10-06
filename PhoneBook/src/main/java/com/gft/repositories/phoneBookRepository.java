package com.gft.repositories;

import com.gft.entities.Address;
import com.gft.entities.PhoneNumber;
import com.gft.entities.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddph on 06/10/2015.
 */
public interface phoneBookRepository {

    public List<Record> getRecordByFullName(String fullName);
    public List<Record> getRecordByPrefix(String prefix);
    public List<Record> getAllRecords();
}
