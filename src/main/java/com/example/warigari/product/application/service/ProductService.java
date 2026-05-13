package com.example.warigari.product.application.service;

import com.example.warigari.common.exception.BusinessException;
import com.example.warigari.product.application.port.in.ProductUseCase;
import com.example.warigari.product.application.port.out.ProductPort;
import com.example.warigari.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductPort productPort;

    @Override
    public List<Product> getProducts() {
        return productPort.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productPort.findById(id)
                .orElseThrow(() -> new BusinessException("상품을 찾을 수 없습니다.", HttpStatus.NOT_FOUND));
    }
}
