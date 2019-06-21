package com.career.genius.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket DSCApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.dcs.controller"))
//                //.paths(PathSelectors.ant("/dcs/**"))
//                .build();
//
//    }

    @Bean
    public Docket geniusApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("API")
                .genericModelSubstitutes(DeferredResult.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.career.genius.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(appApiInfo());

    }



    private ApiInfo appApiInfo() {
        return new ApiInfoBuilder().title("CRM App API")
                .description("")
                .contact(new Contact("crmAppApi", "", ""))
                .version("1.0").build();
    }

}
