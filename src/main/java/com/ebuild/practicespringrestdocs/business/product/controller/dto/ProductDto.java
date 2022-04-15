package com.ebuild.practicespringrestdocs.business.product.controller.dto;

import com.ebuild.practicespringrestdocs.business.product.entity.Product;
import com.ebuild.practicespringrestdocs.business.product.entity.ProductCategoryCode;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ProductDto {

    @Getter
    @Setter
    public static class Req {
        private String name;
        private Long amount;
        private String categoryCode;
        private LocalDateTime saleStartAt;

        @Builder
        public Req(String name, Long amount, String categoryCode, LocalDateTime saleStartAt) {
            this.name = name;
            this.amount = amount;
            this.categoryCode = categoryCode;
            this.saleStartAt = saleStartAt;
        }

        public Product toEntity(){
            return Product.builder()
                .name(name)
                .categoryCode(ProductCategoryCode.valueOf(categoryCode))
                .amount(amount)
                .saleStartAt(saleStartAt)
                .build();
        }
    }


    @Getter
    @Setter
    public static class Res {
        private Long id;
        private String name;
        private Long amount;
        private ProductCategoryCode categoryCode;
        private LocalDateTime saleStartAt;

        @Builder
        public Res(Long id, String name, Long amount,
            ProductCategoryCode categoryCode, LocalDateTime saleStartAt) {
            this.id = id;
            this.name = name;
            this.amount = amount;
            this.categoryCode = categoryCode;
            this.saleStartAt = saleStartAt;
        }

        public static Res of(Product entity){
            return Res.builder()
                .id(entity.getId())
                .name(entity.getName())
                .categoryCode(entity.getCategoryCode())
                .amount(entity.getAmount())
                .saleStartAt(entity.getSaleStartAt())
                .build();
        }

    }

}
