package com.uniproject.unitproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uniproject.unitproject.entities.Landmark;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark, Long> {
}
