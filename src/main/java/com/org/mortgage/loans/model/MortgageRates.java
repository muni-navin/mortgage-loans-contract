package com.org.mortgage.loans.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MortgageRates {

    @Schema(description = "Mortgage unique identifier in the database")
    Long id;

    @Schema(description = "Maturity period of mortgage loans")
    Integer maturityPeriod;

    @Schema(description = "Interest rate of mortgage loans")
    BigDecimal interestRate;

    @Schema(description = "Property owner or Tenant password")
    Timestamp lastUpdated;
}
