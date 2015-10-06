package com.gft.controllers;

/**
 * Created by ddph on 06/10/2015.
 */

import com.gft.entities.Record;
import com.gft.services.PhoneBookService;
import com.gft.servicesImpl.phoneBookServiceImp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;


@Path("/phoneBookService")
public class PhoneBookController {

    PhoneBookService phoneBookService = new phoneBookServiceImp();

    @GET
    @Path("/json/allRecords/")
    @Produces("application/json")
    public String listAllRecordsJSON() {
        return phoneBookService.getAllRecords();

    }
    @GET
    @Path("/json/byNameRecord/{fullName}")
    @Produces("application/json")
    public String listRecordsByFullNameJSON(@PathParam("fullName")String fullName){
        return phoneBookService.getRecordByFullName(fullName);
    }

    @GET
    @Path("/json/byPrefixRecord/{prefix}")
    @Produces("application/json")
    public String listRecordsByPrefixJSON(@PathParam("prefix")String prefix){
        return phoneBookService.getRecordByPrefix(prefix);
    }


}