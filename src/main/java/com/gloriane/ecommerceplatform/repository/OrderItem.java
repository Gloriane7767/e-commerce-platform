package com.gloriane.ecommerceplatform.repository;

import java.util.List;

public interface OrderItem {
    List<OrderItem> findByOrder_Id(Long orderId);
    List<OrderItem> findByProduct_Id(Long productId);
    List<OrderItem> findByQuantityGreaterThan(Integer quantity);
}


