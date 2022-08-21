package com.salihynbl.fttechnology.dto.productComment;

import com.salihynbl.fttechnology.model.ProductComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCommentDto {

    private UUID id;

    private String content;

    private LocalDate commentDate;

    private UUID userId;

    private UUID productId;

    public static ProductCommentDto from(ProductComment productComment){
        return ProductCommentDto.builder()
                .id(productComment.getId())
                .content(productComment.getContent())
                .commentDate(productComment.getCommentDate())
                .productId(productComment.getProduct().getId())
                .userId(productComment.getUser().getId()).build();
    }

}
