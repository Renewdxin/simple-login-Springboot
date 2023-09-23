package com.example.config;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.RestBean;
import com.example.service.authorizeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;

@SuppressWarnings("ALL")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Resource
    authorizeService service;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        return security
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .anyRequest().authenticated())
                .formLogin((formlogin) ->
                        formlogin
                                .loginProcessingUrl("/api/auth/login")
                                .successHandler(this::onAuthenticationSuccess)
                                .failureHandler(this::onAuthenticationFailure)
                )
                .logout((logout) ->
                        logout
                                .logoutUrl("/api/auth/logout")
                                .logoutSuccessHandler(this::onAuthenticationSuccess))
                //.userDetailsService(service)
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling((handling) ->
                        handling
                                .authenticationEntryPoint(this::onAuthenticationFailure))
                .cors((cors) ->
                        cors
                                .configurationSource(this.corsConfigurationSource()))

                .build();
    }

    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*");
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.addExposedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity security) throws Exception {
        return security
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(service)
                .and().build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSONObject.toJSONString(RestBean.failure(401, e.getMessage())));
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setCharacterEncoding("utf-8");
        if(request.getRequestURI().endsWith("/login")) {
            response.getWriter().write(JSONObject.toJSONString(RestBean.success("SUCCESSFULLY LOG IN")));
        } else if(request.getRequestURI().endsWith("/logout")){
            response.getWriter().write(JSONObject.toJSONString(RestBean.success("SUCCESSFULLY LOG OUT")));
        }

    }
}
