package com.uniproject.unitproject.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.uniproject.unitproject.entities.Campsite;

public interface CampsiteService {
    Campsite create(Campsite campsite);

    Optional<Campsite> findById(Long id);

    List<Campsite> findAll();

    Campsite update(Long id, Campsite campsite);

    void delete(Long id);
}
