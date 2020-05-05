package com.bridgelabz.quantityconverter.repository;

import com.bridgelabz.quantityconverter.model.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, String> {
}
