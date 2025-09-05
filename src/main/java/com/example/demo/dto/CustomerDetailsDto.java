package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsDto {
    @NotEmpty(message = "customer name must not be null or empty")
    @Size(min = 1, max = 50, message = "length of customer name must be between 1 and 50")
    private String customerName;

    @NotEmpty(message = "email must not be null or empty")
    @Email(message = "Email must be of correct value")
    private String email;

    @NotEmpty(message = "mobile number must not be null or empty")
    private String mobileNumber;
    private AccountDto accountDto;
    private LoansDto loansDto;
}
