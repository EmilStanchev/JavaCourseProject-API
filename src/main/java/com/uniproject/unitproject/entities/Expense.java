package com.uniproject.unitproject.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Embeddable
@Data
public class Expense {
    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Double amount;

    private Instant createdAt;

    @Column(nullable = false)
    private String name;

    private String notes = "";

    @PrePersist
    public void prePersist() {
        if (createdAt == null)
            createdAt = Instant.now();
    }

    // getters/setters
}
