package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Account;

public interface AccountService {
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    Boolean updateAccount(CustomerDto customerDto);
}
