package com.example.warigari.product.adapter.out;

import com.example.warigari.product.application.port.out.ProductPort;
import com.example.warigari.product.domain.Category;
import com.example.warigari.product.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Primary
@Component
public class ProductFakeAdapter implements ProductPort {

    private static final List<Product> DUMMY = List.of(
            Product.builder().id(1L).name("기본 티셔츠").description("편한 기본 티셔츠").price(19000).stock(100)
                    .category(Category.builder().id(1L).name("상의").build()).build(),
            Product.builder().id(2L).name("슬림 청바지").description("슬림핏 청바지").price(59000).stock(50)
                    .category(Category.builder().id(2L).name("하의").build()).build(),
            Product.builder().id(3L).name("운동화").description("가벼운 운동화").price(89000).stock(30)
                    .category(Category.builder().id(3L).name("신발").build()).build()
    );

    @Override
    public List<Product> findAll() {
        return DUMMY;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return DUMMY.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
