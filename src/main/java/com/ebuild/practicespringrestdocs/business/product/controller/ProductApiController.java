package com.ebuild.practicespringrestdocs.business.product.controller;

import com.ebuild.practicespringrestdocs.business.product.controller.dto.ProductDto;
import com.ebuild.practicespringrestdocs.business.product.service.ProductService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@RestController
public class ProductApiController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto.Res> create(@RequestBody final ProductDto.Req productRequest) {
        final ProductDto.Res productResDto = productService.create(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto.Res>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto.Res> findById(@PathVariable final Long productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> update(@PathVariable final Long productId, @RequestBody ProductDto.Req productRequest) {
        productService.update(productId, productRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable final Long productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }

}
