package com.alpha.shopapplication.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("Configuring CORS settings");

        registry.addMapping("/**")  // Enable CORS for all paths
                .allowedOrigins("http://localhost:3000")  // Allow requests from the React app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow these HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);
    }
}

