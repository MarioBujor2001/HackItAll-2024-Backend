package com.hackitall.demo.mock;

import com.hackitall.demo.model.EnergyEventDAO;

import java.util.List;
import java.util.Random;

public class MockGenerator {
    private static List<String> deviceIds = List.of("socket1", "socket2", "bulb1", "bulb2", "ac1", "ac2");
    private static Random random = new Random();
    public static EnergyEventDAO generateEvent() {
        EnergyEventDAO energyEventDAO = new EnergyEventDAO();
        energyEventDAO.setId(deviceIds.get(random.nextInt(0, deviceIds.size()-1)));
        energyEventDAO.setConsumption(random.nextFloat(0, 100));
        energyEventDAO.setStatus(random.nextBoolean());
        energyEventDAO.setTimestamp(System.currentTimeMillis()/1000L);
        return energyEventDAO;
    }
}
