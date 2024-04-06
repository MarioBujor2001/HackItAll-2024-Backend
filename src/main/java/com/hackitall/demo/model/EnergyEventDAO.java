package com.hackitall.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnergyEventDAO {
    private String name;
    private String email;
    private String space;
    private Float consumption;
    private Boolean status;
    private Long timestamp;
}
