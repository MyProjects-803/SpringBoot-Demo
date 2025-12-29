package com.yuga.request;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ProductsRequestDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private Character status;
    private String createdBy;
    private Instant createdDate;
    private String lastUpdatedBy;
    private Instant lastUpdatedDate;
}
