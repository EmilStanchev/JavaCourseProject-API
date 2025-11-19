package com.uniproject.unitproject.services.interfaces;

import com.uniproject.unitproject.entities.Landmark;
import com.uniproject.unitproject.entities.Trip;
import java.util.List;
import java.util.Optional;

public interface LandmarkService {
    Landmark create(Landmark landmark);

    Optional<Landmark> findById(Long id);

    List<Landmark> findAll();

    Landmark update(Long id, Landmark trip);

    void delete(Long id);
}
