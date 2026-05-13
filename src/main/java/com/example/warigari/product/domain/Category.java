package com.example.warigari.product.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Category {

    private Long id;
    private String name;
}
