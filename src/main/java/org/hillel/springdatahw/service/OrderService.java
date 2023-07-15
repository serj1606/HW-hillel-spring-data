package org.hillel.springdatahw.service;

import java.util.List;
import org.hillel.springdatahw.model.Order;

public interface OrderService {
  public List<Order> getAllOrders();

  public Order saveOrder(Order order);

  public Order getOrder(Integer id);

  public void deleteOrder(Integer id);
}