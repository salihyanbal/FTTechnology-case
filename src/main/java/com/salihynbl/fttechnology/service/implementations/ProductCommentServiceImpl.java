package com.salihynbl.fttechnology.service.implementations;

import com.salihynbl.fttechnology.dto.productComment.CreateProductCommentDto;
import com.salihynbl.fttechnology.dto.productComment.ProductCommentDto;
import com.salihynbl.fttechnology.model.ProductComment;
import com.salihynbl.fttechnology.repository.ProductCommentRepository;
import com.salihynbl.fttechnology.service.ProductCommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {

    private ProductCommentRepository productCommentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductCommentServiceImpl(ProductCommentRepository productCommentRepository, ModelMapper modelMapper) {
        this.productCommentRepository = productCommentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProductCommentDto createProductComment(CreateProductCommentDto createProductCommentDto) {
        ProductComment productCommentToSave = this.modelMapper.map(createProductCommentDto, ProductComment.class);
        return this.modelMapper.map(this.productCommentRepository.save(productCommentToSave), ProductCommentDto.class);
    }

    @Override
    public List<ProductCommentDto> getCommentsByProductId(UUID productId) {
        List<ProductComment> productComments = this.productCommentRepository.getByProduct_Id(productId);
        return productComments.stream().map(ProductCommentDto::from).collect(Collectors.toList());
    }

    @Override
    public List<ProductCommentDto> getCommentsByDateAndProductId(UUID productId, LocalDate startDate, LocalDate endDate) {
        List<ProductComment> productComments = this.productCommentRepository.getByProduct_IdAndCommentDateBetween(productId, startDate, endDate);
        return productComments.stream().map(ProductCommentDto::from).collect(Collectors.toList());    }

    @Override
    public List<ProductCommentDto> getCommentsByUserId(UUID userId) {
        List<ProductComment> productComments = this.productCommentRepository.getByUser_Id(userId);
        return productComments.stream().map(ProductCommentDto::from).collect(Collectors.toList());
    }

    @Override
    public List<ProductCommentDto> getCommentsByDateAndUserId(UUID userId, LocalDate startDate, LocalDate endDate) {
        List<ProductComment> productComments = this.productCommentRepository.getByUser_IdAndCommentDateBetween(userId, startDate, endDate);
        return productComments.stream().map(ProductCommentDto::from).collect(Collectors.toList());
    }
}
