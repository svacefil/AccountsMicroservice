package com.example.demo.mapper;

import com.example.demo.dto.CustomerDetailsDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;

public class CustomerMapper {
    private CustomerMapper() {}

    public static CustomerDto mapCustomerToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName(customer.getCustomerName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setAccountDto(
                AccountMapper.mapAccountToAccountDto(customer.getAccount())
        );
        return customerDto;
    }

    public static CustomerDetailsDto mapCustomerToCustomerDetailsDto(Customer customer) {
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        customerDetailsDto.setCustomerName(customer.getCustomerName());
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setMobileNumber(customer.getMobileNumber());
        return customerDetailsDto;
    }

    public static Customer mapCustomerDtoToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setAccount(
                AccountMapper.mapAccountDtoToAccount(customerDto.getAccountDto())
        );
        return customer;
    }
}
