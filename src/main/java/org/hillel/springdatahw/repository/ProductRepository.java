package org.hillel.springdatahw.repository;

import org.hillel.springdatahw.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
