package com.uniproject.unitproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uniproject.unitproject.entities.Campsite;

@Repository
public interface CampsiteRepository extends JpaRepository<Campsite, Long> {
}