package com.github.jgzl.dataflux.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;

@Configuration
public class RedisConfiguration {
    @Bean
    public ReactiveStringRedisTemplate reactiveRedisTemplate(ReactiveRedisConnectionFactory redisConnectionFactory){
        return new ReactiveStringRedisTemplate(redisConnectionFactory);
    }
}
