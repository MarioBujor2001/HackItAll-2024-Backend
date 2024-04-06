package com.hackitall.demo.mock;

import com.hackitall.demo.model.EnergyEventDAO;

import java.util.*;

public class MockGenerator {
    private static String email = "test@gmail.com";
    private static Map<String, List<String>> spaces = new HashMap<>(){{
        put("Living", List.of("Living_AirConditioning",
                "Living_Lights",
                "Living_Outlet"));
        put("Bedroom", List.of("Bedroom_Light_1",
                "Bedroom_RGB_Lights",
                "Bedroom_Outlet"));
        }
    };
    private static Random random = new Random();
    public static List<EnergyEventDAO> generateEvents() {
        List<EnergyEventDAO> mockEvents = new ArrayList<>();
        for(Map.Entry<String, List<String>> spacesEntry : spaces.entrySet()){
            for(String deviceName : spacesEntry.getValue()){
                EnergyEventDAO mockEvent = new EnergyEventDAO();
                mockEvent.setName(deviceName);
                mockEvent.setSpace(spacesEntry.getKey());
                mockEvent.setTimestamp(System.currentTimeMillis()/1000L);
                mockEvent.setEmail(email);
                mockEvent.setConsumption(random.nextFloat(0, 100));
                mockEvent.setStatus(true);
                mockEvents.add(mockEvent);
            }
        }
        return mockEvents;
    }
}
