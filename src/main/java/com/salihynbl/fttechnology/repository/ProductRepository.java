package com.salihynbl.fttechnology.repository;

import com.salihynbl.fttechnology.dto.product.ProductDto;
import com.salihynbl.fttechnology.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> getByExpirationDateGreaterThanEqualOrExpirationDateIsNull(LocalDate date);
    List<Product> getByExpirationDateBefore(LocalDate date);
}
