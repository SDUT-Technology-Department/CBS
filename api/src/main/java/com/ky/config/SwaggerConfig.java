package com.ky.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /*
    * 1. 配置文档信息
    * 2. 配置生成规则*/

    /*Docket用于封装接口信息*/
    @Bean
    public Docket getDocket(){
        /* 获取接口/抽象类对象
        new接口，并在构造器的{}中实现接口的所有抽象方法
        new子类/实现类
        工厂模式（此处使用工厂模式）*/

        //创建封面信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("《借教室系统》后端接口说明文档")
                .description("此文档详细说说明了《借教室系统》的后端接口规范和所有功能点")
                .version("v 0.0.1")
                .contact(new Contact("计科2003张开源","","kaiyuanosg@outlook.com"));
        ApiInfo apiInfo = apiInfoBuilder.build();


        Docket docket = new Docket(DocumentationType.SWAGGER_2) //指定文档风格
                .apiInfo(apiInfo)//指定生成的文档中封面信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ky"))
//              .paths(PathSelectors.regex("/user/"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}
