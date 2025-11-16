package com.uniproject.unitproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uniproject.unitproject.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}