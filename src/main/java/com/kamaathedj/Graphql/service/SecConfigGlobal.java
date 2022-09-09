package com.kamaathedj.Graphql.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
//
@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = false,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecConfigGlobal extends GlobalMethodSecurityConfiguration {
}
