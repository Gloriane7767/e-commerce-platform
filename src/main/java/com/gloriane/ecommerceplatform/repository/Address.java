package com.gloriane.ecommerceplatform.repository;

import org.hibernate.annotations.processing.Find;

public interface Address {
    void findAllAddressBySpecificZipCode(String zipCode);
}
