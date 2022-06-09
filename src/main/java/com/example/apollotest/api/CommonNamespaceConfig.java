package com.example.apollotest.api;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

/**
 * 公共Namespace配置
 */
public class CommonNamespaceConfig {

    public static void main(String[] args) {

        String publicNamespace = "TEST1.CAT";

        Config config = ConfigService.getConfig(publicNamespace); //config instance is singleton for each namespace and is never null
        String someKey = "someKeyFromPublicNamespace";
        String someDefaultValue = "默认";
        String value = config.getProperty(someKey, someDefaultValue);

        System.out.println("公共Namespace的配置：" + value);
    }
}
