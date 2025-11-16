package com.uniproject.unitproject.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uniproject.unitproject.entities.Campsite;
import com.uniproject.unitproject.services.interfaces.CampsiteService;

import java.util.List;

@RestController
@RequestMapping("/api/campsites")
public class CampsiteController {

    private final CampsiteService service;

    public CampsiteController(CampsiteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Campsite>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campsite> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Campsite> create(@RequestBody Campsite campsite) {
        Campsite created = service.create(campsite);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campsite> update(@PathVariable Long id, @RequestBody Campsite campsite) {
        try {
            Campsite updated = service.update(id, campsite);
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
