package com.yuga.service;

import com.yuga.entity.ProductsEntity;
import com.yuga.repo.ProductsRepo;
import com.yuga.request.ProductsRequestDto;
import com.yuga.response.ProductsResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepo productsRepo;

    public ProductsResponseDto saveProductInfo(ProductsRequestDto dto){
        ProductsEntity entity = new ProductsEntity();
        entity.setProductId(dto.getProductId());
        entity.setProductName(dto.getProductName());
        entity.setProductDescription(dto.getProductDescription());
        entity.setStatus(dto.getStatus());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedDate(Instant.now());
        entity.setLastUpdatedBy(dto.getLastUpdatedBy());
        entity.setLastUpdateDate(Instant.now());
        productsRepo.save(entity);
        ProductsResponseDto responseDto = new ProductsResponseDto();
        responseDto.setMsg("Product info saved successfully for the Product id: "+ entity.getProductId());
        return responseDto;
    }
}
