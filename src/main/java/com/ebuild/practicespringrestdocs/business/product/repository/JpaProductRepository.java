package com.ebuild.practicespringrestdocs.business.product.repository;

import com.ebuild.practicespringrestdocs.business.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> {

}
