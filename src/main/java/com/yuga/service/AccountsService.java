package com.yuga.service;

import com.yuga.entity.AccountsEntity;
import com.yuga.repo.AccountsRepo;
import com.yuga.request.AccountsRequestDto;
import com.yuga.response.AccountsResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepo accountsRepo;

    public AccountsResponseDto saveAccountsInfo(AccountsRequestDto requestDto){
        AccountsResponseDto accountsResponseDto = new AccountsResponseDto();
        AccountsEntity accountsEntity = new AccountsEntity();
        accountsEntity.setAccountId(requestDto.getAccountId());
        accountsEntity.setFirstName(requestDto.getFirstName());
        accountsEntity.setLastName(requestDto.getLastName());
        accountsEntity.setAadhar(requestDto.getAadhar());
        accountsEntity.setPhoneNumber(requestDto.getPhoneNumber());
        accountsEntity.setAccountType(requestDto.getAccountType());
        accountsEntity.setStatus(requestDto.getStatus());
        accountsEntity.setCreatedBy(requestDto.getCreatedBy());
        accountsEntity.setCreatedDate(Instant.now());
        accountsEntity.setLastUpdatedBy(requestDto.getLastUpdatedBy());
        accountsEntity.setLastUpdatedDate(Instant.now());
        accountsRepo.save(accountsEntity);
        accountsResponseDto.setMsg("Account Id: "+accountsEntity.getAccountId() + " account info saved successfully");
        return accountsResponseDto;

    }
}
