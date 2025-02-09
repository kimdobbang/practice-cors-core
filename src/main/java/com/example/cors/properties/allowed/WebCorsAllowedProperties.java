package com.example.cors.properties.allowed;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

@ConfigurationPropertiesBinding // 속성값에 넣어둔걸 여기에 붙인다(루트가 되는애는 @ConfigurationProperties 도 추가)
public record WebCorsAllowedProperties(
        String[] headers,
        String[] methods, // enum도 매핑은 가능 -> HTTP Method는 표준에서도 확장된 메서드 허용하므로 문자열
        String[] origins,
        Boolean credentials // Boolean (wrapper class)
) {
}
