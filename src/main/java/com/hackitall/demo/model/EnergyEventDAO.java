package com.hackitall.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnergyEventDAO {
    private String name;
    private String email;
    private String space;
    private Float consumption;
    private Boolean status;
    private Long timestamp;

    public EnergyEventDAO(EnergyEventDAO copy){
        this.name = copy.getName();
        this.email = copy.getEmail();
        this.space = copy.getSpace();
        this.consumption = copy.getConsumption();
        this.status = copy.getStatus();
        this.timestamp = copy.getTimestamp();
    }
}
