package com.uniproject.unitproject.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Campsite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String location;
    private String description;
    private String longDesc;

    private double latitude;
    private double longitude;

    @ElementCollection
    private List<String> images;

    @ElementCollection
    private List<String> utilities;

    private String country;

    @Embedded
    private Price price;

    private int places;

    @ElementCollection
    private List<String> tags;

    @Embeddable
    @Data
    public static class Price {
        private double perNight;
        private String currency;
        private String additionalNotes;
    }
}
