package com.android.agenda.dao;

import com.android.agenda.model.CreateDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverDao {

    private final static List<CreateDriver> drivers = new ArrayList<>();

    public void saveDriver(CreateDriver driver) {
        drivers.add(driver);
    }

    public List<CreateDriver> allDrivers() {
        return new ArrayList<>(drivers);
    }
}
