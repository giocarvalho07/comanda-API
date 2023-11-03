package com.comandaai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsFilter {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/**") // Defina os caminhos que devem ter CORS ativado
                        .allowedOrigins("http://127.0.0.1:5500") // Adicione as origens permitidas
                        .allowedOrigins("https://comanda-api.onrender.com/") // Adicione as origens permitidas
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Especifique os métodos permitidos
                        .allowedHeaders("*"); // Permita todos os cabeçalhos (ajuste de acordo com suas necessidades)
            }
        };
    }
}
