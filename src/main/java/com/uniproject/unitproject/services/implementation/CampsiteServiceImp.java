package com.uniproject.unitproject.services.implementation;


import org.springframework.stereotype.Service;

import com.uniproject.unitproject.entities.Campsite;
import com.uniproject.unitproject.repositories.CampsiteRepository;
import com.uniproject.unitproject.services.interfaces.CampsiteService;

import java.util.List;
import java.util.Optional;

@Service
public class CampsiteServiceImp implements CampsiteService {

    private final CampsiteRepository repo;

    public CampsiteServiceImp(CampsiteRepository repo) {
        this.repo = repo;
    }

    @Override
    public Campsite create(Campsite campsite) {
        return repo.save(campsite);
    }

    @Override
    public Optional<Campsite> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Campsite> findAll() {
        return repo.findAll();
    }

    @Override
    public Campsite update(Long id, Campsite campsite) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(campsite.getTitle());
            existing.setLocation(campsite.getLocation());
            existing.setDescription(campsite.getDescription());
            existing.setLongDesc(campsite.getLongDesc());
            existing.setLatitude(campsite.getLatitude());
            existing.setLongitude(campsite.getLongitude());
            existing.setImages(campsite.getImages());
            existing.setUtilities(campsite.getUtilities());
            existing.setCountry(campsite.getCountry());
            existing.setPrice(campsite.getPrice());
            existing.setPlaces(campsite.getPlaces());
            existing.setTags(campsite.getTags());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Campsite not found with id " + id));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
