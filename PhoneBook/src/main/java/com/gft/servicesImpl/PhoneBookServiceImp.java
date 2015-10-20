package com.gft.servicesImpl;

import com.gft.repositories.PhoneBookRepository;
import com.gft.repositoriesImpl.PhoneBookRepositoryImpl;
import com.gft.services.PhoneBookService;
import com.google.gson.Gson;

import java.sql.SQLException;

/**
 * Created by ddph on 06/10/2015.
 */
public class PhoneBookServiceImp implements PhoneBookService {
    PhoneBookRepository PhoneBookRepository = new PhoneBookRepositoryImpl();

    public String getRecordByFullName(String fullName) throws SQLException {
        return new Gson().toJson(PhoneBookRepository.getRecordByFullName(fullName));
    }

    public String getRecordByPrefix(String prefix) throws SQLException {
        return new Gson().toJson(PhoneBookRepository.getRecordByPrefix(prefix));
    }

    public String getAllRecords() throws SQLException {
        return new Gson().toJson(PhoneBookRepository.getAllRecords());
    }



}
