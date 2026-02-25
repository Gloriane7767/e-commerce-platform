package com.gloriane.ecommerceplatform.repository;

import com.gloriane.ecommerceplatform.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(
            LocalDate date1, LocalDate date2
    );
    Optional<Promotion> findByCode(String code);
    List<Promotion> findByStartDateAfter(LocalDate date);
    List<Promotion> findByEndDateBefore(LocalDate date);
    List<Promotion> findByEndDateIsNull();
}
