package org.hillel.springdatahw.service;

import org.hillel.springdatahw.exeption.NoSuchOrderException;
import org.hillel.springdatahw.model.Order;
import org.hillel.springdatahw.model.Product;
import org.hillel.springdatahw.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderRepository orderRepository;

  @Override
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  @Override
  public Order saveOrder(Order order) {
    order.setDate(LocalDateTime.now());
    order.setCost(getOrderCost(order.getProducts()));

    orderRepository.save(order);
    return order;
  }

  private BigDecimal getOrderCost(List<Product> productList) {
    BigDecimal totalCost = BigDecimal.ZERO;
    for (Product product : productList) {
      totalCost = totalCost.add(product.getCost());
    }
    return totalCost;
  }

  @Override
  public Order getOrder(Integer id) {
    Optional<Order> optional = orderRepository.findById(id);
    if (optional.isEmpty()) {
      throw new NoSuchOrderException("There is no order with ID = " + id + " in Database.");
    }
    return optional.get();
  }

  @Override
  public void deleteOrder(Integer id) {
    orderRepository.deleteById(id);
  }
}
