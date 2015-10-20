package com.gft.repositories;

import com.gft.entities.Address;
import com.gft.entities.PhoneNumber;
import com.gft.entities.Record;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddph on 06/10/2015.
 */
public interface PhoneBookRepository {

    public List<Record> getRecordByFullName(String fullName) throws SQLException;
    public List<Record> getRecordByPrefix(String prefix) throws SQLException;
    public List<Record> getAllRecords() throws SQLException;
}
