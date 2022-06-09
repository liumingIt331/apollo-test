package com.example.apollotest.api;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

public class ConfigTest {

    public static void main(String[] args) {
        Config config = ConfigService.getAppConfig(); //config instance is singleton for each namespace and is never null
        String configKey = "spring.datasource.name";
        String defaultDatasourceName = "jdbc";
        String datasourceName = config.getProperty(configKey, defaultDatasourceName);
        System.out.println("获取配置信息，datasourceName = " + datasourceName);
    }
}
