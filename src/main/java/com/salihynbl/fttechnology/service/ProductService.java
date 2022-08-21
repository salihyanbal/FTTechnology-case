package com.salihynbl.fttechnology.service;

import com.salihynbl.fttechnology.dto.product.CreateProductDto;
import com.salihynbl.fttechnology.dto.product.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(CreateProductDto createProductDto);
    List<ProductDto> getIfExpired();
    List<ProductDto> getIfNotExpired();
}
