package com.gloriane.ecommerceplatform.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter // This annotation generates getter methods for all fields in the class.
@Setter // This annotation generates setter methods for all fields in the class.
@AllArgsConstructor // This annotation generates a constructor with parameters for all fields in the class.
@NoArgsConstructor // This annotation generates a no-argument constructor for the class.
@ToString // This annotation generates a toString() method for the class, which is useful for debugging and logging purposes.
@EqualsAndHashCode // This annotation generates equals() and hashCode() methods for the class, which are important for comparing objects and using them in collections.
@ Builder // This annotation generates a builder pattern for the class, allowing for more flexible and readable object creation.

@Entity // This annotation indicates that this class is a JPA entity and will be mapped to a database table.
@Table(name = "user_profiles") // This annotation specifies the name of the database table that this entity will be mapped to.
public class UserProfile {
    @Id // This annotation indicates that the field 'id' is the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation specifies that the value of the primary key will be generated automatically by the database using an identity
    private Long id;

    @Column(length = 100) // This annotation specifies that the 'nickName' column in the database will have a maximum length of 100 characters.
    private String nickName;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 500)
    private String bio;

}
