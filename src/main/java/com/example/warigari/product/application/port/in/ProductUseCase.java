package com.example.warigari.product.application.port.in;

import com.example.warigari.product.domain.Product;

import java.util.List;

public interface ProductUseCase {

    List<Product> getProducts();
    Product getProduct(Long id);
}
