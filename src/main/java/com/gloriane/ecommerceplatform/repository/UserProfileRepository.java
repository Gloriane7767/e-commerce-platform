package com.gloriane.ecommerceplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository {
     void findByUserNickName(String nickName);
     void searchByPartialPhoneNumber(String partialPhoneNumber);
}
