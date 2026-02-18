package com.gloriane.ecommerceplatform.repository;

import com.gloriane.ecommerceplatform.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByNickName(String nickName);
    List<UserProfile> findByPhoneNumberContaining(String partialPhoneNumber);
}
