package com.uniproject.unitproject.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.uniproject.unitproject.entities.Trip;

public interface TripService {
    Trip create(Trip trip);

    Optional<Trip> findById(Long id);

    List<Trip> findAll();

    Trip update(Long id, Trip trip);

    void delete(Long id);
}
