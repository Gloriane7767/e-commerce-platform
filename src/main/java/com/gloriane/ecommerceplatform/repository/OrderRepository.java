package com.gloriane.ecommerceplatform.repository;

import com.gloriane.ecommerceplatform.entity.Order;
import com.gloriane.ecommerceplatform.entity.OrderStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer_Id(Long customerId);

    @EntityGraph(attributePaths = {"items"}) // Without @EntityGraphLoad order → then load items one by one. With it:Load order + items in one query
    List<Order> findByStatus(OrderStatus status);

    List<Order> findByOrderDateAfter(Instant date);

    List<Order> findByOrderDateBetween(Instant start, Instant end);

    long countByStatus(OrderStatus status);

    List<Order> findByCustomer_IdAndStatus(Long customerId, OrderStatus status);
}
