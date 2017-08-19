package com.github.jstumpp.spring.whoops.spring;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.embedded.Ssl.ClientAuth;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;

/**
 * Settings that define the whoops behaviour.
 *
 * <pre>
 * # In application.yml
 * whoops:
 *   # If whoops exception page should NOT be enabled:
 *   # enabled: false
 * </pre>
 */
@Validated
@ConfigurationProperties(prefix = "whoops")
public class SpringWhoopsProperties {

    private boolean m_enabled = true;

    /**
     * @return Whether any {@code @Bean}s should be injected at all.
     */
    public boolean isEnabled() {
        return m_enabled;
    }
    public void setEnabled(boolean enabled) {
        m_enabled = enabled;
    }
}
