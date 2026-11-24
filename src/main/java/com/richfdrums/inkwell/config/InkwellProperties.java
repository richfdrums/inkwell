package com.richfdrums.inkwell.config;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("inkwell")
@Validated
public record InkwellProperties(
        @NotBlank String siteName,
        @DefaultValue("20")
        @Max(50)
        @Positive
        int defaultPageSize) {
}
