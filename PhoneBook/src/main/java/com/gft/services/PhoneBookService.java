package com.gft.services;

import com.gft.entities.Record;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ddph on 06/10/2015.
 */
public interface PhoneBookService {

    public String getRecordByFullName(String fullName) throws SQLException;

    public String getRecordByPrefix(String prefix) throws SQLException;

    public String getAllRecords() throws SQLException;


}
