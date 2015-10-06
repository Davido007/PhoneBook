package com.gft.servicesImpl;

import com.gft.entities.Record;
import com.gft.repositories.phoneBookRepository;
import com.gft.repositoriesImpl.phoneBookRepositoryImpl;
import com.gft.services.PhoneBookService;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ddph on 06/10/2015.
 */
public class phoneBookServiceImp implements PhoneBookService {
    phoneBookRepository phoneBookRepository = new phoneBookRepositoryImpl();
    public String getRecordByFullName(String fullName) {
        return new Gson().toJson(phoneBookRepository.getRecordByFullName(fullName));
    }

    public String getRecordByPrefix(String prefix) {
        return new Gson().toJson(phoneBookRepository.getRecordByPrefix(prefix));
    }

    public String getAllRecords() {
        return new Gson().toJson(phoneBookRepository.getAllRecords());
    }
}
