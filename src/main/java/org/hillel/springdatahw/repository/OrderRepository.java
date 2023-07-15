package org.hillel.springdatahw.repository;

import org.hillel.springdatahw.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}