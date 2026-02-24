package com.gloriane.ecommerceplatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ElementCollection // Store the elements of this collection in a table named product_images.
    @CollectionTable( // The join column product_id links each image row to the owning product row (the product's primary key).
            name = "product_images",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @Column(name = "image_url") // The column that stores the String values in the product_images table will be named image_url.
    private List<String> imageUrls = new ArrayList<>();

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}

 /*
    You have a field in a JPA entity: List<string> imageUrls;</string>
    The annotations tell JPA to store that list in its own database table (not as columns of the main product table) even though the list items are plain Strings (not separate entity objects).
    This field is a collection of basic values (Strings, numbers, enums) or embeddables, not a collection of other entity objects."
    JPA will treat each String in the list as a value to be persisted in a separate collection table that belongs to the parent entity.
     */