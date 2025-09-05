package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long accountNumber;

    @NotEmpty(message = "account type must not be null or empty")
    private String accountType;

    @NotEmpty(message = "branch address must not be null or empty")
    private String branchAddress;
}
