package com.example.web;

import com.example.cors.properties.WebCorsProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(WebCorsProperties.class) // <<< 이번만 이렇게
//@ConfigurationPropertiesScan(basePackages = "com.example")
public class CorsConfig implements WebMvcConfigurer {

    private final WebCorsProperties webCorsProperties;

    public CorsConfig(WebCorsProperties webCorsProperties) {
        this.webCorsProperties = webCorsProperties;
    }


    // Ctrl + I -> CORS Mapping 관련 함수

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        WebMvcConfigurer.super.addCorsMappings(registry); <<< 현재 하는 일 없음 지워도 됨
        var allowed = webCorsProperties.allowed();
        var exposed = webCorsProperties.exposed();
        var maxAge = webCorsProperties.maxAge();

        registry.addMapping("/**")
                .allowedOrigins(allowed.headers()) // *: asterisk, 기능적으로 "와일드카드" 역할로 자주 사용됨.
                .allowedMethods(allowed.methods()) // 공통(GET, POST, PUT(주로 패치보다 put), PATCH, DELETE, HEAD, OPTION, TRACE) + 확장된 메서드 들(뭐가 될지 모름)
                .allowedOrigins(allowed.origins())
                .allowCredentials(allowed.credentials())
                .exposedHeaders(exposed.headers())
                .maxAge(maxAge);

    }
}
