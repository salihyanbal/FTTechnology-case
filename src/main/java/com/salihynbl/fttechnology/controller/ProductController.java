package com.salihynbl.fttechnology.controller;

import com.salihynbl.fttechnology.dto.product.CreateProductDto;
import com.salihynbl.fttechnology.model.Product;
import com.salihynbl.fttechnology.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody CreateProductDto createProductDto){
        return ResponseEntity.ok(this.productService.createProduct(createProductDto));
    }

    @GetMapping("/getExpireds")
    private ResponseEntity<?> getExpireds(){
        return ResponseEntity.ok(this.productService.getIfExpired());
    }

    @GetMapping("/getNotExpireds")
    private ResponseEntity<?> getNotExpireds(){
        return ResponseEntity.ok(this.productService.getIfNotExpired());
    }
}
