package com.gloriane.ecommerceplatform.repository;

import com.gloriane.ecommerceplatform.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByZipCode(String zipCode);
}
