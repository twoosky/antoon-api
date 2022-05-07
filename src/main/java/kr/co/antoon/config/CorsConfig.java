package kr.co.antoon.config;

import kr.co.antoon.config.properties.CorsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.constraints.NotNull;

@Configuration
@EnableConfigurationProperties(CorsProperties.class)
@RequiredArgsConstructor
public class CorsConfig implements WebMvcConfigurer {
    private static final String ADAPTING_URL = "/**";

    @NotNull
    private final CorsProperties corsProperties;

    @Bean
    public UrlBasedCorsConfigurationSource corsSource() {
        var config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.addAllowedHeader(corsProperties.getAllowedHeaders());
        config.addAllowedMethod(corsProperties.getAllowedMethods());
        config.addAllowedOriginPattern(corsProperties.getAllowedOrigins());
        config.setMaxAge(corsProperties.getMaxAge());

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(ADAPTING_URL, config);
        return source;
    }
}