package com.example.cors.properties.exposed;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

@ConfigurationPropertiesBinding // 속성값에 넣어둔걸 여기에 붙인다(루트가 되는애는 @ConfigurationProperties 도 추가)
public record WebCorsExposedProperties(String[] headers) {
}
