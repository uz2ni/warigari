package com.example.warigari.product.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {

    private Long id;
    private String name;
    private String description;
    private int price;
    private int stock;
    private Category category;
}
