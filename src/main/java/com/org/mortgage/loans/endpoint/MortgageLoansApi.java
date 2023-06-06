package com.org.mortgage.loans.endpoint;

import com.org.mortgage.loans.model.ApiErrorResponse;
import com.org.mortgage.loans.model.MortgageChecks;
import com.org.mortgage.loans.model.MortgageRates;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = MortgageLoansApi.REQUEST_MAPPING)
public interface MortgageLoansApi {

    String REQUEST_MAPPING = "/api";

    @Operation(description = "interest-rates", operationId = "/interest-rates", summary = "Fetching all the registered interest rates")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(
                    schema = @Schema(implementation = MortgageRates.class))),
            @ApiResponse(responseCode = "404", description = "No Mortgage rates found", content = @Content(
                    schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<List<MortgageRates>> interestRates();

    @Operation(summary = "Checking the mortgage loans eligibility")
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(
                    schema = @Schema(implementation = MortgageChecks.class))),
            @ApiResponse(responseCode = "400", description = "Internal error", content = @Content(
                    schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<MortgageChecks> mortgageCheck(@Valid @RequestBody MortgageChecks mortgageChecks);
}
