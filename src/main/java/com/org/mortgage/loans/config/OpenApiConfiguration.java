package com.org.mortgage.loans.config;

import com.org.mortgage.loans.model.DocumentationProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Optional;

@Configuration
@EnableConfigurationProperties(DocumentationProperties.class)
@PropertySource(value = "classpath:/mortgage-loan-contract.properties")
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI(DocumentationProperties documentationProperties) {
        return new OpenAPI().info(apiInfo(documentationProperties));
    }

    private Info apiInfo(DocumentationProperties documentationProperties) {
        return new Info()
                .title(documentationProperties.getApiTitle())
                .description(documentationProperties.getApiDescription())
                .version(Optional.ofNullable(getClass().getPackage().getImplementationVersion()).orElse("n/a"))
                .contact(new Contact().name(documentationProperties.getTeamName()).url(documentationProperties.getTeamUrl()).email(documentationProperties.getTeamEmail()))
                .license(new License().name("(C) MUNI"));
    }

}
