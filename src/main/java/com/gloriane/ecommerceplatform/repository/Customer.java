package com.gloriane.ecommerceplatform.repository;

public interface Customer {
     void findCustomerByUniqueEmail(String email);
    void findCustomersByLastName(String lastName);
     void findCustomersBySpecificCity(String city);
}
