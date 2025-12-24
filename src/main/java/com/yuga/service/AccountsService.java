package com.yuga.service;

import com.yuga.entity.AccountsEntity;
import com.yuga.repo.AccountsRepo;
import com.yuga.request.AccountsRequestDto;
import com.yuga.response.AccountDetailsResponseDto;
import com.yuga.response.AccountsResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.Instant;
import java.util.Optional;

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

    public AccountDetailsResponseDto getAccountInfo(Long aadhar){
        AccountDetailsResponseDto response = new AccountDetailsResponseDto();
        Optional<AccountsEntity> entity = accountsRepo.findByAadhar(aadhar);
        if(entity.isPresent()) {
            AccountsEntity entityInfo = entity.get();
            response.setAccountId(entityInfo.getAccountId());
            response.setFirstName(entityInfo.getFirstName());
            response.setLastName(entityInfo.getLastName());
            response.setAadhar(entityInfo.getAadhar());
            response.setPhoneNumber(entityInfo.getPhoneNumber());
            response.setAccountType(entityInfo.getAccountType());
            response.setStatus(entityInfo.getStatus());
            response.setCreatedBy(entityInfo.getCreatedBy());
            response.setCreatedDate(entityInfo.getCreatedDate());
            response.setLastUpdatedBy(entityInfo.getLastUpdatedBy());
            response.setLastUpdateDate(entityInfo.getLastUpdatedDate());
        }


        return response;
    }
}
