package com.yuga.controller;

import com.yuga.request.ProductsRequestDto;
import com.yuga.response.ProductsDetailsResponseDto;
import com.yuga.response.ProductsResponseDto;
import com.yuga.service.ProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Tag(name = "Product APIs", description = "APIs for Product Information")
public class ProductsController {

    @Autowired
    private ProductsService service;

    @PostMapping("/save")
    public ResponseEntity<ProductsResponseDto> saveProductsInfo(@RequestBody ProductsRequestDto dto){
        ProductsResponseDto responseDto = service.saveProductInfo(dto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{productId}")
    @Operation(
            summary = "Get Product information by Product ID",
            description = "Fetch product details based on productId"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ProductsDetailsResponseDto> getProductById(
            @PathVariable Long productId) {

        return ResponseEntity.ok(service.getProductById(productId));
    }
}
