package com.salihynbl.fttechnology.service.implementations;

import com.salihynbl.fttechnology.dto.product.CreateProductDto;
import com.salihynbl.fttechnology.dto.product.ProductDto;
import com.salihynbl.fttechnology.model.Product;
import com.salihynbl.fttechnology.repository.ProductRepository;
import com.salihynbl.fttechnology.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProductDto createProduct(CreateProductDto createProductDto) {
        Product productToSave = this.modelMapper.map(createProductDto, Product.class);
        return this.modelMapper.map(this.productRepository.save(productToSave), ProductDto.class);
    }

    @Override
    public List<ProductDto> getIfExpired() {
        List<Product> products = this.productRepository.getByExpirationDateBefore(LocalDate.now());
        return products.stream().map(product -> this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getIfNotExpired() {
        List<Product> products = this.productRepository.getByExpirationDateGreaterThanEqualOrExpirationDateIsNull(LocalDate.now());
        return products.stream().map(product -> this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
    }
}
