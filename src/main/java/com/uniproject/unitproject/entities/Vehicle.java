package com.uniproject.unitproject.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Vehicle {
    private String brand = "";
    private String model = "";
    private Integer year;
}
