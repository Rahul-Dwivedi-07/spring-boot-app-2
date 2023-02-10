package com.RahulDwivedi.springbootapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//we can override the methods present in WebMvcConfigurer according to our needs
public class WebConfig implements WebMvcConfigurer {

    //content negotiation added
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        //with that parameter we want to do content negotiation
        configurer.favorParameter(true)
                .parameterName("mediaType")
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml",MediaType.APPLICATION_XML)
                .mediaType("json",MediaType.APPLICATION_JSON);
    }
}
