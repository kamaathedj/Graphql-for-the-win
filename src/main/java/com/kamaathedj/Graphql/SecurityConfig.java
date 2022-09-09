package com.kamaathedj.Graphql;

import com.kamaathedj.Graphql.model.LoginUser;
import com.kamaathedj.Graphql.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableReactiveMethodSecurity
@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(31);
    }

    @Bean
    public SecurityWebFilterChain Chain(ServerHttpSecurity security) throws Exception {
        return security.httpBasic(Customizer.withDefaults())
                .authorizeExchange(ae -> ae
                        .anyExchange().permitAll())
                .csrf(csrfSpec -> csrfSpec.disable())
                .build();
    }

    @Bean
    MapReactiveUserDetailsService userDetailsService() {
        var pass = this.passwordEncoder().encode("kam1234");
        System.out.println(pass);
        LoginUser l = new LoginUser("kamaa", pass, true);
        UserDetails kamaa = new UserService.UserServiceDetails(new UserService.UserServiceDetails(l));
        return new MapReactiveUserDetailsService(kamaa);
    }


}
