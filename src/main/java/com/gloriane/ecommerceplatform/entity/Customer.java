package com.gloriane.ecommerceplatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@Entity
@Table(name="Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstname;

    @Column(nullable = false, length = 100)
    private String lastname;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(nullable = false, length = 100)
    private Instant createdAt;

    @Column(nullable = false, length = 100)
    private Address address;

    @OneToOne // @OneToOne - defines the one-to-one relationship
    @JoinColumn(name = "user_profile_id") // @JoinColumn(name = "profile_id") - creates a foreign key column called profile_id in the customers table
    private UserProfile userProfile;

    @PrePersist
    private void prePersist() {
        createdAt = Instant.now();
    }
}
