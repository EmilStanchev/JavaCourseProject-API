package com.uniproject.unitproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uniproject.unitproject.entities.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
