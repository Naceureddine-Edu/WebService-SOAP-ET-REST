package com.banque.openapiconfiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
@OpenAPIDefinition
@AllArgsConstructor
public class OpenApiConfiguration
{
    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
                                 @Value("${application-version}") String appVersion,
                                 @Value("${application-name}") String appName)
    {
        return new OpenAPI()
                .info(new Info()
                .title(appName)
                .description(appDesciption)
                .version(appVersion)
                .termsOfService("http://swagger.io/terms/")
                .license(getLicense()));
    }

    private License getLicense() {
        return new License()
                .name("EMSI")
                .url("https://emsi.ma/");
    }
}
