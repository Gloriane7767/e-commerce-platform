package com.gloriane.ecommerceplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer extends JpaRepository {
     void findCustomerByUniqueEmail(String email);
    void findCustomersByLastName(String lastName);
     void findCustomersBySpecificCity(String city);
}
