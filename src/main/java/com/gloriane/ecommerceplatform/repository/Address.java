package com.gloriane.ecommerceplatform.repository;

import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Address extends JpaRepository {
    void findAllAddressBySpecificZipCode(String zipCode);
}
