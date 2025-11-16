package com.uniproject.unitproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uniproject.unitproject.entities.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
