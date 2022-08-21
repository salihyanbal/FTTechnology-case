package com.salihynbl.fttechnology.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salihynbl.fttechnology.dto.common.DateBetween;
import com.salihynbl.fttechnology.dto.productComment.CreateProductCommentDto;
import com.salihynbl.fttechnology.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/productComment")
public class ProductCommentController {

    private ProductCommentService productCommentService;

    @Autowired
    public ProductCommentController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProductComment(@Valid @RequestBody CreateProductCommentDto createProductCommentDto){
        return ResponseEntity.ok(this.productCommentService.createProductComment(createProductCommentDto));
    }

    @GetMapping("/getByProductId/{productId}")
    public ResponseEntity<?> getByProductId(@PathVariable UUID productId){
        return ResponseEntity.ok(this.productCommentService.getCommentsByProductId(productId));
    }

    @PostMapping("/getByProductIdAndBetweenDates/{productId}")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public ResponseEntity<?> getByProductIdAndBetweenDates(@PathVariable UUID productId,
                                                           @RequestBody DateBetween dateBetween){
        return ResponseEntity.ok(this.productCommentService.getCommentsByDateAndProductId(productId, dateBetween.getStartDate(), dateBetween.getEndDate()));
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(this.productCommentService.getCommentsByUserId(userId));
    }

    @PostMapping("/getByUserIdAndBetweenDates/{userId}")
    public ResponseEntity<?> getByUserIdAndBetweenDates(@PathVariable UUID userId,
                                                        @RequestBody DateBetween dateBetween){
        return ResponseEntity.ok(this.productCommentService.getCommentsByDateAndUserId(userId, dateBetween.getStartDate(), dateBetween.getEndDate()));
    }
}
