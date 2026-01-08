package com.yuga.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AccountDetailsResponseDto {

    private Long accountId;
    private String firstName;
    private String lastName;
    private Long aadhar;
    private Long phoneNumber;
    private String accountType;
    private Character status;
    private String createdBy;
    private Instant createdDate;
    private String lastUpdatedBy;
    private Instant lastUpdateDate;

}
