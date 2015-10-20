package com.gft.controllers;

/**
 * Created by ddph on 06/10/2015.
 */

import com.gft.services.PhoneBookService;
import com.gft.servicesImpl.PhoneBookServiceImp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.SQLException;


@Path("/phoneBookService")
public class PhoneBookController {

    PhoneBookService phoneBookService = new PhoneBookServiceImp();

    @GET
    @Path("/json/allRecords/")
    @Produces("application/json")
    public String listAllRecordsJSON() throws SQLException {
        System.out.println(phoneBookService.getAllRecords().length());
        return phoneBookService.getAllRecords();

    }

    @GET
    @Path("/json/byNameRecord/{fullName}")
    @Produces("application/json")
    public String listRecordsByFullNameJSON(@PathParam("fullName") String fullName) throws SQLException {
        return phoneBookService.getRecordByFullName(fullName);
    }

    @GET
    @Path("/json/byPrefixRecord/{prefix}")
    @Produces("application/json")
    public String listRecordsByPrefixJSON(@PathParam("prefix") String prefix) throws SQLException {
        return phoneBookService.getRecordByPrefix(prefix);
    }
}