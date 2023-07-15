package org.hillel.springdatahw.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private LocalDateTime date;
  private BigDecimal cost;
  @OneToMany(cascade = {CascadeType.ALL})
  @JoinColumn(name= "order_id")
  private List<Product> products;
}
