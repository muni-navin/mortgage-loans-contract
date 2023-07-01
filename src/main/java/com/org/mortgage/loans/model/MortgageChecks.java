package com.org.mortgage.loans.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MortgageChecks {

    @Schema(description = "Mortgage check unique identifier in the database")
    Long id;

    @Schema(description = "Income of the customer")
    @NotNull
    BigDecimal income;

    @Schema(description = "Maturity period of mortgage loans")
    @NotNull
    Integer maturityPeriod;

    @Schema(description = "Loan amount requested by the customer")
    @NotNull
    BigDecimal loanValue;

    @Schema(description = "Home value that will be sold by the customer")
    @NotNull
    BigDecimal homeValue;

    @Schema(description = "Loan granted or not")
    Boolean loanGranted;
}
