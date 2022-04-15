package com.ebuild.practicespringrestdocs.business.product.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long amount;
    @Enumerated(value = EnumType.STRING)
    private ProductCategoryCode categoryCode;
    private LocalDateTime saleStartAt;

    @Builder
    public Product(Long id, String name, Long amount,
        ProductCategoryCode categoryCode, LocalDateTime saleStartAt) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.categoryCode = categoryCode;
        this.saleStartAt = saleStartAt;
    }
}
