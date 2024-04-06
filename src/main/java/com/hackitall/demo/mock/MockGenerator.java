package com.hackitall.demo.mock;

import com.hackitall.demo.model.EnergyEventDAO;

import java.util.*;

public class MockGenerator {
    private static final Random random = new Random();

    public static List<EnergyEventDAO> generateEvents() {
        List<EnergyEventDAO> mockEvents = new ArrayList<>();
        for (Map.Entry<Integer, EnergyEventDAO> spacesEntry : MockCollection.mocks.entrySet()) {
            EnergyEventDAO mock = new EnergyEventDAO(spacesEntry.getValue());
            mock.setTimestamp(System.currentTimeMillis());
            mock.setConsumption(mock.getConsumption() == 0 ? 0 : random.nextFloat(mock.getConsumption() - 10, mock.getConsumption()) + 10);
            mockEvents.add(mock);
        }
        return mockEvents;
    }
}
