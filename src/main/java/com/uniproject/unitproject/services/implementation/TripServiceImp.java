package com.uniproject.unitproject.services.implementation;


import com.uniproject.unitproject.entities.Trip;
import com.uniproject.unitproject.repositories.TripRepository;
import com.uniproject.unitproject.services.interfaces.TripService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImp implements TripService {

    private final TripRepository tripRepository;

    public TripServiceImp(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip create(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Optional<Trip> findById(Long id) {
        return tripRepository.findById(id);
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public Trip update(Long id, Trip updatedTrip) {
        Trip existing = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id " + id));

        existing.setTitle(updatedTrip.getTitle());
        existing.setDescription(updatedTrip.getDescription());
        existing.setLongDesc(updatedTrip.getLongDesc());
        existing.setTag(updatedTrip.getTag());
        existing.setLikes(updatedTrip.getLikes());
        existing.setTotalDistance(updatedTrip.getTotalDistance());

        existing.setStops(updatedTrip.getStops());
        existing.setLandmarks(updatedTrip.getLandmarks());
        existing.setUser(updatedTrip.getUser()); 

        return tripRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!tripRepository.existsById(id)) {
            throw new RuntimeException("Trip not found with id " + id);
        }
        tripRepository.deleteById(id);
    }
}
