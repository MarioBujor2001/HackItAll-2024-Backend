package com.hackitall.demo.controller;

import com.hackitall.demo.mock.MockCollection;
import com.hackitall.demo.model.EnergyEventDAO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/events")
public class EventController {
    @PutMapping("/{email}/{name}")
    public void updateStatus(@PathVariable("email") String email,
                             @PathVariable("name") String name,
                             @RequestBody Boolean status){
        EnergyEventDAO event = MockCollection.mocks
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getEmail().equals(email) && e.getValue().getName().equals(name))
                .findFirst()
                .get().getValue();
        event.setStatus(status);
        if(!status){
            event.setConsumption(0f);
        }else{
            if (event.getConsumption() == 0f){
                event.setConsumption(new Random().nextFloat(50,100));
            }
        }
    }
}
