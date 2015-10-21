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
    static final String DB_URL = "jdbc:mysql://localhost/phonebook_database";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "admin";


    public List<Record> getRecordByFullName(String fullName) throws SQLException {
        Connection conn;
        Statement stmt;
        List<Record> records = new ArrayList<Record>();
        String sql ="SELECT a.firstname, a.surname, b.city, b.street, b.houseNumber, c.prefix, c.number\n" +
                "FROM person a\n" +
                "JOIN address b ON b.id_address = a.address_id_address\n" +
                "INNER JOIN number c ON c.id_phoneNumber = a.number_id_phoneNumber\n" +
                "WHERE a.surname = '" + fullName + "';";
        conn = getDBConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        ResultSet rs = getResultSet(sql, stmt);
        records = getRecords(rs, records);
        closeObjects(conn, rs, stmt);
        return records;
    }

    public List<Record> getRecordByPrefix(String prefix) throws SQLException {
        Connection conn;
        Statement stmt;
        List<Record> records = new ArrayList<Record>();
        String sql ="SELECT a.firstname, a.surname, b.city, b.street, b.houseNumber, c.prefix, c.number\n" +
                "FROM person a\n" +
                "JOIN address b ON b.id_address = a.address_id_address\n" +
                "INNER JOIN number c ON c.id_phoneNumber = a.number_id_phoneNumber\n" +
                "WHERE c.prefix = '" + prefix + "';";
        conn = getDBConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        ResultSet rs = getResultSet(sql, stmt);
        records = getRecords(rs, records);
        closeObjects(conn, rs, stmt);
        return records;
    }

    public List<Record> getAllRecords() throws SQLException {
        Connection conn;
        Statement stmt;
        List<Record> records = new ArrayList<Record>();
        String sql = "SELECT a.firstname, a.surname, b.city, b.street, b.houseNumber, c.prefix, c.number\n" +
                "FROM person a\n" +
                "JOIN address b ON b.id_address = a.address_id_address\n" +
                "INNER JOIN number c ON c.id_phoneNumber = a.number_id_phoneNumber;";
        conn = getDBConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        ResultSet rs = getResultSet(sql, stmt);
        records = getRecords(rs, records);
        closeObjects(conn, rs, stmt);
        return records;
    }

    public Connection getDBConnection(String dbUrl, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public ResultSet getResultSet(String sql, Statement stmt) {
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Record> getRecords(ResultSet rs, List<Record> records) throws SQLException {
        while (rs.next()) {
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
        return records;
    }

    public void closeObjects(Connection conn, ResultSet rs, Statement stmt) {
        try {
            conn.close();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }
    }
}
