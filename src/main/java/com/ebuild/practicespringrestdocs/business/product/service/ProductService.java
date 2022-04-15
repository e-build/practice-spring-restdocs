package com.ebuild.practicespringrestdocs.business.product.service;

import com.ebuild.practicespringrestdocs.business.product.controller.dto.ProductDto;
import com.ebuild.practicespringrestdocs.business.product.controller.dto.ProductDto.Req;
import com.ebuild.practicespringrestdocs.business.product.repository.JpaProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final JpaProductRepository jpaProductRepository;

    public ProductDto.Res create(Req productRequest) {
        return ProductDto.Res
            .of(
                jpaProductRepository.save(
                    productRequest.toEntity()
                )
            );
    }

    public List<ProductDto.Res> findAll() {
        return null;
    }

    public ProductDto.Res findById(Long productId) {
        return null;
    }

    public void update(Long productId, Req productRequest) {

    }

    public void delete(Long productId) {

    }
}
