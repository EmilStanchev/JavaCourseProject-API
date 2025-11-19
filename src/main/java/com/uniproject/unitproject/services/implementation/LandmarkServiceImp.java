package com.uniproject.unitproject.services.implementation;

import com.uniproject.unitproject.entities.Landmark;
import com.uniproject.unitproject.repositories.LandmarkRepository;
import com.uniproject.unitproject.services.interfaces.LandmarkService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandmarkServiceImp implements LandmarkService {

    private final LandmarkRepository landmarkRepository;

    public LandmarkServiceImp(LandmarkRepository landmarkRepository) {
        this.landmarkRepository = landmarkRepository;
    }

    @Override
    public Landmark create(Landmark landmark) {
        return landmarkRepository.save(landmark);
    }

    @Override
    public Optional<Landmark> findById(Long id) {
        return landmarkRepository.findById(id);
    }

    @Override
    public List<Landmark> findAll() {
        return landmarkRepository.findAll();
    }

    @Override
    public Landmark update(Long id, Landmark updatedLandmark) {
        Landmark existing = landmarkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id " + id));

        existing.setTitle(updatedLandmark.getTitle());
        existing.setDescription(updatedLandmark.getDescription());
        existing.setImages(updatedLandmark.getImages());
        existing.setLatitude(updatedLandmark.getLatitude());
        existing.setLongitude(updatedLandmark.getLongitude());
        existing.setNearCampsite(updatedLandmark.getNearCampsite());
        existing.setRating(updatedLandmark.getRating());
        existing.setCreatedAt(updatedLandmark.getCreatedAt());
        existing.setUpdatedAt(updatedLandmark.getUpdatedAt());


        return landmarkRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!landmarkRepository.existsById(id)) {
            throw new RuntimeException("Trip not found with id " + id);
        }
        landmarkRepository.deleteById(id);
    }
}
