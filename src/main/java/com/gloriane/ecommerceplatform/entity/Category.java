package com.gloriane.ecommerceplatform.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "categories")
public class Category {
        @Id
        @GeneratedValue(Strategy = jakarta.persistence.GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String name;


}
