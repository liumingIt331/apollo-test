package com.example.apollotest.springboot;

import com.ctrip.framework.apollo.core.ConfigConsts;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 利用springcloud的RefreshScope及ApolloConfigChangeListener监听
 * 对ConfigurationProperties进行apollo的热更新
 */
@Data
@ConditionalOnProperty("redis.cache.enable")
@Component
public class SpringBootApolloRefreshConfig {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootApolloRefreshConfig.class);

    private final SimpleRedisConfig simpleRedisConfig;
    private final RefreshScope refreshScope;

    @ApolloConfigChangeListener(value = {ConfigConsts.NAMESPACE_APPLICATION, "TEST1.CAT", "application.properties"},
            interestedKeyPrefixes = {"redis.cache."})
    public void onChange(ConfigChangeEvent changeEvent) {
        logger.info("检测到配置更新");
        logger.info("更新前的配置：{}", simpleRedisConfig.toString());
        refreshScope.refresh("simpleRedisConfig");
        logger.info("更新后的配置：{}", simpleRedisConfig.toString());
    }
}
