package com.AirTic.ClothesProject.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            // Desactivar CSRF para pruebas (considera activarlo en producción)
            .csrf(csrf -> csrf.disable())
            
            // Configuración de login
            .formLogin(httpForm -> {
                httpForm
                    .loginPage("/login")
                    .permitAll();
            })
            
            .authorizeHttpRequests(registry -> {
                registry.requestMatchers("/req/signup", "/signup", "/register", "/css/**", "/js/**", "/images/**", "/te", "/").permitAll();
                
                registry.requestMatchers("/api/register/**").permitAll();
                
                registry.anyRequest().authenticated();
            })
            
            // Construir la configuración
            .build();
    }
}