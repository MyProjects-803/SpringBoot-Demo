package com.yuga.controller;

import com.yuga.request.ProductsRequestDto;
import com.yuga.response.ProductsResponseDto;
import com.yuga.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService service;

    @PostMapping("/save")
    public ResponseEntity<ProductsResponseDto> saveProductsInfo(@RequestBody ProductsRequestDto dto){
        ProductsResponseDto responseDto = service.saveProductInfo(dto);
        return ResponseEntity.ok(responseDto);
    }
}
