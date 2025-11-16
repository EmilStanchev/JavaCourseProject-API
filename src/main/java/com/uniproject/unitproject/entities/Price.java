package com.uniproject.unitproject.entities;

import jakarta.persistence.*;

@Embeddable
public class Price {
    @Column(name = "per_night")
    private Double perNight;

    private String currency;

    @Column(columnDefinition = "TEXT")
    private String additionalNotes;

    // getters/setters
}
