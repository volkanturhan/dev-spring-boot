package com.volkanturhan.springcoredemo.config;

import com.volkanturhan.springcoredemo.common.Coach;
import com.volkanturhan.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
