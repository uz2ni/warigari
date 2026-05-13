package com.example.warigari.product.adapter.in;

import com.example.warigari.common.response.ApiResponse;
import com.example.warigari.product.application.port.in.ProductUseCase;
import com.example.warigari.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCase productUseCase;

    @GetMapping
    public ApiResponse<List<Product>> getProducts() {
        return ApiResponse.ok(productUseCase.getProducts());
    }

    @GetMapping("/{id}")
    public ApiResponse<Product> getProduct(@PathVariable Long id) {
        return ApiResponse.ok(productUseCase.getProduct(id));
    }
}
