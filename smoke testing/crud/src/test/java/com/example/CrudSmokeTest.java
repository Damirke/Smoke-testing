package com.example;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class MyCrudSmokeTest {
    private MyCrud myCrud;

    @Before
    public void setUp() {
        myCrud = new MyCrud();
    }
    
    @Test
    public void testCreateRecord() {
        MyRecord record = new MyRecord("Capybara", 19, "capybara@gmail.com");
        try {
            myCrud.createRecord(record);
        } catch (SQLException e) {
            fail("Creating record denied through exception: " + e.getMessage());
        }
    }

    @Test
    public void testReadAllRecords() {
        try {
            myCrud.readAllRecords();
        } catch (SQLException e) {
            fail("Reading all records denied through the exception: " + e.getMessage());
        }
    }

    @Test
    public void testReadRecordById() {
        int id = 5;
        try {
            boolean isFound = myCrud.readRecordById(id);
            assertTrue("Record with ID 5 is not found", isFound);
        } catch (SQLException e) {
            fail("Reading record by ID denied through exception: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateRecordById() {
        MyRecord record = new MyRecord(5, "Winx", 28, "wakingupat8@gmail.com");
        try {
            myCrud.updateRecordById(record);
        } catch (SQLException e) {
            fail("Updating record denied through exception: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteRecordById() {
        int id = 5;
        try {
            myCrud.deleteRecordById(id);
        } catch (SQLException e) {
            fail("Deletion denied through exception: " + e.getMessage());
        }
    }
}
