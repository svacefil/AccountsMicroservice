package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Setter
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapCustomerDtoToCustomer(customerDto);
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");

        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (customerOptional.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with mobile number " + customerDto.getMobileNumber() + " already exists");
        }

        var account = createNewAccount(customer);
        customer.setAccount(account);
        customerRepository.save(customer);


    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        return CustomerMapper.mapCustomerToCustomerDto(customer);
    }

    @Override
    public Boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        var accountsDto = customerDto.getAccountDto();

        if (accountsDto != null) {
            Account account = accountRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "Account number", accountsDto.getAccountType())
            );
            var customer = account.getCustomer();
            account.setAccountType(accountsDto.getAccountType());
            account.setBranchAddress(accountsDto.getBranchAddress());
            customer.setAccount(account);
            customerRepository.saveAndFlush(customer);
            isUpdated = true;
        }else {
            isUpdated = false;
        }
        return isUpdated;
    }

    private Account createNewAccount(Customer customer){
        Account account = new Account();
        account.setCustomer(customer);
        account.setAccountType("savings");
        account.setBranchAddress("fokume");
        account.setCreatedAt(LocalDateTime.now());
        account.setCreatedBy("Anonymous");

        return account;

    }
}
