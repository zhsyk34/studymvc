package com.cat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.MultipartConfigElement;

@Configuration
//@ComponentScan(basePackageClasses = {},
//        excludeFilters =
//                {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {RequestMapping.class, Controller.class, RestController.class}
//                )})
@Import({AppConfig.class})
class RootConfig {

    @Bean("multipartResolver")
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(AppConfig appConfig) {
        return new MultipartConfigElement(appConfig.getDir());
    }
}
