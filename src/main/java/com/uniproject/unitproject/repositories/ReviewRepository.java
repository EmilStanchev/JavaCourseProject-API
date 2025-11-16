package com.uniproject.unitproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uniproject.unitproject.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
