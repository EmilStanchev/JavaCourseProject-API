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

    // simple list of review ids or just texts; better to map relation if needed.
    @ElementCollection
    @CollectionTable(name = "trip_reviews", joinColumns = @JoinColumn(name = "trip_id"))
    @Column(name = "review_text")
    private List<String> reviews;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double totalDistance = 0.0;

    @ManyToMany
    @JoinTable(name = "trip_landmarks", joinColumns = @JoinColumn(name = "trip_id"), inverseJoinColumns = @JoinColumn(name = "landmark_id"))
    private List<Landmark> landmarks;

    @ElementCollection
    @CollectionTable(name = "trip_gear", joinColumns = @JoinColumn(name = "trip_id"))
    private List<GearItem> gear;

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
