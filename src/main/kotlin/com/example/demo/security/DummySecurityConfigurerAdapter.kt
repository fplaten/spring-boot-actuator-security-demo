package com.example.demo.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
class DummySecurityConfigurerAdapter {

    @Bean
    @Order(1)
    @Throws(Exception::class)
    fun dummyFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .authorizeHttpRequests()
            .anyRequest()
            .permitAll()
        return http.build()
    }
}