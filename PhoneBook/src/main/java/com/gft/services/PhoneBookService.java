package com.gft.services;

import com.gft.entities.Record;

import java.util.List;

/**
 * Created by ddph on 06/10/2015.
 */
public interface PhoneBookService {

    public String getRecordByFullName(String fullName);

    public String getRecordByPrefix(String prefix);

    public String getAllRecords();
}
