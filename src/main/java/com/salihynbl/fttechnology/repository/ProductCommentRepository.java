package com.salihynbl.fttechnology.repository;

import com.salihynbl.fttechnology.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProductCommentRepository extends JpaRepository<ProductComment, UUID> {
    List<ProductComment> getByProduct_Id(UUID productId);
    List<ProductComment> getByProduct_IdAndCommentDateBetween(UUID productId, LocalDate commentDateAfter, LocalDate commentDateBefore);
    List<ProductComment> getByUser_Id(UUID userId);
    List<ProductComment> getByUser_IdAndCommentDateBetween(UUID userId, LocalDate commentDateAfter, LocalDate commentDateBefore);

}
