package com.uniproject.unitproject.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "landmarks")
@Data
public class Landmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double longitude;
    private Double latitude;

    @ElementCollection
    @CollectionTable(name = "landmark_images", joinColumns = @JoinColumn(name = "landmark_id"))
    @Column(name = "image")
    private List<String> images;

    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "near_campsite_id")
    @JsonIgnore

    private Campsite nearCampsite;

    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    // getters/setters
}
