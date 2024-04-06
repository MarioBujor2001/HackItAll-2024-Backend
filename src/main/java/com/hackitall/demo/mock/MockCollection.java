package com.hackitall.demo.mock;

import com.hackitall.demo.model.EnergyEventDAO;

import java.util.HashMap;
import java.util.Map;

public class MockCollection {
    public static Map<Integer, EnergyEventDAO> mocks = new HashMap<>();
    static {
        mocks.put(1, new EnergyEventDAO("Living_AirConditioning",
                "test@gmail.com",
                "Living",
                80f,
                true,
                null));
        mocks.put(2, new EnergyEventDAO("Living_Lights",
                "test@gmail.com",
                "Living",
                70f,
                true,
                null));
        mocks.put(3, new EnergyEventDAO("Bedroom_Light_1",
                "test@gmail.com",
                "Bedroom",
                60f,
                true,
                null));
        mocks.put(4, new EnergyEventDAO("Bedroom_RGB_Lights",
                "test@gmail.com",
                "Bedroom",
                30f,
                true,
                null));
        mocks.put(5, new EnergyEventDAO("Bedroom_Outlet",
                "test@gmail.com",
                "Bedroom",
                90f,
                true,
                null));
    }
}
