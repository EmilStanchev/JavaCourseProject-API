package com.uniproject.unitproject.entities;


import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "trips")
@Data
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String longDesc;

    @ManyToMany
    @JoinTable(name = "trip_stops", joinColumns = @JoinColumn(name = "trip_id"), inverseJoinColumns = @JoinColumn(name = "campsite_id"))
    private List<Campsite> stops;

    private String tag;
    private Integer likes = 0;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double totalDistance = 0.0;

    @ManyToMany
    @JoinTable(name = "trip_landmarks", joinColumns = @JoinColumn(name = "trip_id"), inverseJoinColumns = @JoinColumn(name = "landmark_id"))
    private List<Landmark> landmarks;

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
}
