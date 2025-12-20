package com.yuga.controller;

import com.yuga.request.AccountsRequestDto;
import com.yuga.response.AccountsResponseDto;
import com.yuga.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @PostMapping("/save")
    public ResponseEntity<AccountsResponseDto> saveAccountsInfo(@RequestBody AccountsRequestDto dto){
        AccountsResponseDto responseDto = accountsService.saveAccountsInfo(dto);
        return ResponseEntity.ok(responseDto);
    }
}
