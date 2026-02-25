package com.gloriane.ecommerceplatform.repository;

import com.gloriane.ecommerceplatform.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
    List<Category> findByNameContainingIgnoreCase(String keyword);
    long count();
}

