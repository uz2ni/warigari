package com.example.warigari.product.adapter.out;

import com.example.warigari.product.application.port.out.ProductPort;
import com.example.warigari.product.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductJpaAdapter implements ProductPort {

    @Override
    public List<Product> findAll() {
        // TODO: JPA Entity 매핑 후 구현
        return List.of();
    }

    @Override
    public Optional<Product> findById(Long id) {
        // TODO: JPA Entity 매핑 후 구현
        return Optional.empty();
    }
}
