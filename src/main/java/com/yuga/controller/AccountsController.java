package com.yuga.controller;

import com.yuga.request.AccountsRequestDto;
import com.yuga.response.AccountDetailsResponseDto;
import com.yuga.response.AccountsResponseDto;
import com.yuga.service.AccountsService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get")
    public ResponseEntity<AccountDetailsResponseDto> fetchAccountInfo(@RequestParam Long aadhar){
        AccountDetailsResponseDto responseDto = accountsService.getAccountInfo(aadhar);
        return ResponseEntity.ok(responseDto);
    }


}
