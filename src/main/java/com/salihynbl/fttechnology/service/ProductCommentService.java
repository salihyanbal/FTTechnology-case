package com.salihynbl.fttechnology.service;

import com.salihynbl.fttechnology.dto.productComment.CreateProductCommentDto;
import com.salihynbl.fttechnology.dto.productComment.ProductCommentDto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProductCommentService {

    ProductCommentDto createProductComment(CreateProductCommentDto createProductCommentDto);
    List<ProductCommentDto> getCommentsByProductId(UUID productId);
    List<ProductCommentDto> getCommentsByDateAndProductId(UUID productId, LocalDate startDate, LocalDate endDate);
    List<ProductCommentDto> getCommentsByUserId(UUID userId);
    List<ProductCommentDto> getCommentsByDateAndUserId(UUID userId, LocalDate startDate, LocalDate endDate);

}
