package com.uniproject.unitproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uniproject.unitproject.entities.Landmark;
import com.uniproject.unitproject.entities.Trip;
import com.uniproject.unitproject.services.interfaces.LandmarkService;
import com.uniproject.unitproject.services.interfaces.TripService;

import java.util.List;

@RestController
@RequestMapping("/api/landmarks")
public class LandmarkController {

    private final LandmarkService service;

    public LandmarkController(LandmarkService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Landmark>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Landmark> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Landmark> create(@RequestBody Landmark landmark) {
        Landmark created = service.create(landmark);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Landmark> update(@PathVariable Long id, @RequestBody Landmark landmark) {
        try {
            Landmark updated = service.update(id, landmark);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
