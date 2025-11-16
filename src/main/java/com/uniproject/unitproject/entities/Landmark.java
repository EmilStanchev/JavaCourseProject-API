package com.uniproject.unitproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "landmarks")
@Data
public class Landmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;
    @NotNull
    @Column(columnDefinition = "TEXT")
    private String desc;
    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;

    @ElementCollection
    @CollectionTable(name = "landmark_images", joinColumns = @JoinColumn(name = "landmark_id"))
    @Column(name = "image")
    private List<String> images;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "near_campsite_id", nullable = false)
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
