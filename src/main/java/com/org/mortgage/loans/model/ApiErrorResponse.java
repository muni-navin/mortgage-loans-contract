package com.org.mortgage.loans.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorResponse {

    @Schema(description = "Http error code")
    private Integer errorCode;
    @Schema(description = "User friendly error message")
    private String message;
    @Schema(description = "The specific point in time that the exception occurred")
    private DateTime timeStamp;
}
