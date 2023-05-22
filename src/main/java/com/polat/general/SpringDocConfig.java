package com.polat.general;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MPolat
 */

@OpenAPIDefinition
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI OpenApiBase() {
        return new OpenAPI().info(new Info().title("AkbankHW2"));
    }

}
