package com.example.warigari.product.application.port.out;

import com.example.warigari.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductPort {

    List<Product> findAll();
    Optional<Product> findById(Long id);
}
