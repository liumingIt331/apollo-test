package com.example.apollotest.springboot;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@ConditionalOnProperty("redis.cache.enable")
@Component
@ConfigurationProperties(prefix = "redis.cache")
@RefreshScope
public class SimpleRedisConfig {
    private static final Logger logger = LoggerFactory.getLogger(SimpleRedisConfig.class);

    private Integer expireSeconds;
    private Integer commandTimeout;
}
