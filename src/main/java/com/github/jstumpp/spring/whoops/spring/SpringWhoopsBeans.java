package com.github.jstumpp.spring.whoops.spring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Defines Spring beans that are used for Spring Whoops
 */
@Configuration
@SpringWhoopsBeans.ConditionalOnEnabled
public class SpringWhoopsBeans {

    @ConditionalOnProperty(value = "whoops.enabled", matchIfMissing = true)
    public static @interface ConditionalOnEnabled {
    }

    @ConditionalOnEnabled
    @ConditionalOnWebApplication
    @ConditionalOnProperty(value = "whoops.serverCustomizationEnabled", matchIfMissing = true)
    public static @interface ConditionalOnServerCustomizationEnabled {
    }
}
