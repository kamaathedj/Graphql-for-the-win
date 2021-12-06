package com.kamaathedj.Graphql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain Chain(ServerHttpSecurity security) throws Exception{
        return security.httpBasic(Customizer.withDefaults() )
                .authorizeExchange(ae -> ae.anyExchange().permitAll())
                .csrf(csrfSpec -> csrfSpec.disable())
                .build();
    }
    @Bean
    @SuppressWarnings("deprecation")
    MapReactiveUserDetailsService userDetailsService(){
        UserDetails kamaa = User.withDefaultPasswordEncoder()
                .password("kamaa")
                .username("kamaa")
                .roles("ADMIN")
                .build();
        return new MapReactiveUserDetailsService(kamaa);
    }
}
