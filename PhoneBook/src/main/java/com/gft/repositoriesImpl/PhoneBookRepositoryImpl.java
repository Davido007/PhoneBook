package com.gft.repositoriesImpl;

import com.gft.entities.Address;
import com.gft.entities.PhoneNumber;
import com.gft.entities.Record;
import com.gft.repositories.PhoneBookRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddph on 06/10/2015.
 */
public class PhoneBookRepositoryImpl implements PhoneBookRepository {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/phonebook_database";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "admin";

    public List<Record> getRecordByFullName(String fullName) throws SQLException{
//        Record record = new Record();
//        record.setFirstName(fullName);
//        record.setSurname("Adamowski");
//        Address address = new Address();
//        address.setCity("Lleida");
//        address.setHouseNumber("22a");
//        address.setStreet("el General");
//        PhoneNumber phoneNumber = new PhoneNumber();
//        phoneNumber.setPrefix("+48");
//        phoneNumber.setNumber("123 123 123");
//        record.setAddress(address);
//        record.setPhoneNumber(phoneNumber);
//        List<Record> records = new ArrayList<Record>();
//        records.add(record);
//        return records;

        Connection conn = null;
        Statement stmt = null;
        List<Record> records = new ArrayList<Record>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT a.firstname, a.surname, b.city, b.street, b.houseNumber, c.prefix, c.number\n" +
                    "FROM person a\n" +
                    "JOIN address b ON b.id = a.address_id_address\n" +
                    "INNER JOIN number c ON c.id_phoneNumber = a.number_id_phoneNumber\n" +
                    "WHERE a.surname = '" + fullName + "';";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                Record record = new Record();
                Address address = new Address();
                PhoneNumber phoneNumber = new PhoneNumber();

                record.setFirstName(rs.getString("firstname"));
                record.setSurname(rs.getString("surname"));
                phoneNumber.setPrefix(rs.getString("prefix"));
                phoneNumber.setNumber(rs.getString("number"));
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setHouseNumber(rs.getString("houseNumber"));

                record.setAddress(address);
                record.setPhoneNumber(phoneNumber);
                records.add(record);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return records;

    }

    public List<Record> getRecordByPrefix(String prefix) throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        List<Record> records = new ArrayList<Record>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT a.firstname, a.surname, b.city, b.street, b.houseNumber, c.prefix, c.number\n" +
                    "FROM person a\n" +
                    "JOIN address b ON b.id = a.address_id_address\n" +
                    "INNER JOIN number c ON c.id_phoneNumber = a.number_id_phoneNumber\n" +
                    "WHERE c.prefix = '" + prefix + "';";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                Record record = new Record();
                Address address = new Address();
                PhoneNumber phoneNumber = new PhoneNumber();

                record.setFirstName(rs.getString("firstname"));
                record.setSurname(rs.getString("surname"));
                phoneNumber.setPrefix(rs.getString("prefix"));
                phoneNumber.setNumber(rs.getString("number"));
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setHouseNumber(rs.getString("houseNumber"));

                record.setAddress(address);
                record.setPhoneNumber(phoneNumber);
                records.add(record);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return records;
    }

    public List<Record> getAllRecords() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        List<Record> records = new ArrayList<Record>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT a.firstname, a.surname, b.city, b.street, b.houseNumber, c.prefix, c.number\n" +
                    "FROM person a\n" +
                    "JOIN address b ON b.id = a.address_id_address\n" +
                    "INNER JOIN number c ON c.id_phoneNumber = a.number_id_phoneNumber;";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                Record record = new Record();
                Address address = new Address();
                PhoneNumber phoneNumber = new PhoneNumber();

                record.setFirstName(rs.getString("firstname"));
                record.setSurname(rs.getString("surname"));
                phoneNumber.setPrefix(rs.getString("prefix"));
                phoneNumber.setNumber(rs.getString("number"));
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setHouseNumber(rs.getString("houseNumber"));

                record.setAddress(address);
                record.setPhoneNumber(phoneNumber);
                records.add(record);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return records;
    }
}
