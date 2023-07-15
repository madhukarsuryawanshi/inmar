package com.inmar.skudatamanagement.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.datasource")
@EnableConfigurationProperties
@Component
@Data
public class DatabaseProperties {
    private String jdbcUrl;
    private String username;
    private String password;
}
