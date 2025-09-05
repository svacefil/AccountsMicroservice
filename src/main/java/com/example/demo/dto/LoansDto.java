package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoansDto {
    @NotEmpty(message = "Mobile Number can not be a null or empty")
    private String mobileNumber;

    @NotEmpty(message = "Loan Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "LoanNumber must be 12 digits")
    private String loanNumber;

    @NotEmpty(message = "LoanType can not be a null or empty")
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    private Long totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    private Long amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private Long outstandingAmount;

    private LocalDateTime createdAt;

    private String createdBy;
}
