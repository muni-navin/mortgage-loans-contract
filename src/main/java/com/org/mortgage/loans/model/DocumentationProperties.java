package com.org.mortgage.loans.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Validated
@ConfigurationProperties(prefix = "mortgage.contract")
public class DocumentationProperties implements Serializable {

    @NotNull
    @Size(min = 1)
    private String teamName;

    @NotNull
    @Size(min = 1)
    private String teamUrl;

    @NotNull
    @Size(min = 1)
    private String teamEmail;

    @NotNull
    @Size(min = 1)
    private String apiTitle;

    @NotNull
    @Size(min = 1)
    private String apiDescription;
}
