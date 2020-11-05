package org.nero.robbie.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * @author blissleek
 * @version 1.0.0
 * @date 2020/9/27 22:58
 */
@Configuration
@EnableSwagger2
@EnableOpenApi
public class SwaggerConfig {
    /**
     * 是否开启swagger，生产环境一般关闭
     */
    @Value("${springfox.documentation.swagger-ui.enabled}")
    private Boolean enable;

    /**
     * 项目应用名
     */
    @Value("${spring.application.name}")
    private String applicationName;


    @Bean
    Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                .enable(enable)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("org.nero.robbie.api.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .protocols(new LinkedHashSet<>(
                        Arrays.asList("https", "http")))
                .securitySchemes(Collections.singletonList(
                        new ApiKey("Authorization", "admin", "admin")))
                .securityContexts(Collections.singletonList(
                        SecurityContext
                                .builder()
                                .securityReferences(Collections
                                        .singletonList(
                                                new SecurityReference("Authorization",
                                                        new AuthorizationScope[]{
                                                                new AuthorizationScope("global", "accessEverything")
                                                        }
                                                )
                                        )
                                )
                                .build()
                        )
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(applicationName + " Restful API Documents")
                .version("Spring Boot Version: " + SpringBootVersion.getVersion())
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
