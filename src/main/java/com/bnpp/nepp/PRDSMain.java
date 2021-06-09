package com.bnpp.nepp;


import com.bnpp.nepp.controller.PRDSController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@SpringBootApplication
@EnableSwagger2
public class PRDSMain {

    public static void main(String[] args) {
        SpringApplication.run(PRDSMain.class, args);
    }


    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage(PRDSController.class.getPackage().getName())
                )
                .paths(PathSelectors.any())
                .build().apiInfo(appInfo());
    }

    private ApiInfo appInfo(){
        ApiInfo appInfo = new ApiInfo(
                "PRDS",
                "Payment Retrieve Details Service",
                "1.0.0",
                "private",
                "Dummy",
                "Personal API",
                ""
        );

        return appInfo;
    }

}
