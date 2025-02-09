package com.example.cors.properties;

import com.example.cors.properties.allowed.WebCorsAllowedProperties;
import com.example.cors.properties.exposed.WebCorsExposedProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.NestedConfigurationProperty;


@ConfigurationProperties("demo.webmvc.cors") // 빈 등록(속성에서 루트로 삼는 곳) // value는 생략이 가능(value에 alias for 있으면 생략 가능)
@ConfigurationPropertiesBinding // 데이터 바인딩
public record WebCorsProperties(
        @NestedConfigurationProperty WebCorsAllowedProperties allowed,
        @NestedConfigurationProperty WebCorsExposedProperties exposed,
        Long maxAge
) {
}
