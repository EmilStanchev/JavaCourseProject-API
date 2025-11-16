package com.uniproject.unitproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class GearItem {
    @Column(name = "category")
    private String category;

    @Column(name = "title")
    private String title;

}
