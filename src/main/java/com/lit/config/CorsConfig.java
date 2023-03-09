package com.lit.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsWebFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许的请求头
        corsConfiguration.addAllowedHeader("*");
        // 允许的请求源 （如：http://localhost:8080）
        corsConfiguration.addAllowedOrigin("*");
        // 允许的请求方法 ==> GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
        corsConfiguration.addAllowedMethod("*");
        // URL 映射 （如： /admin/**）
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}

