package com.gloriane.ecommerceplatform.repository;

import com.gloriane.ecommerceplatform.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
    List<Customer> findByLastnameIgnoreCase(String lastName);
    List<Customer> findByAddressCity(String city);
}
