package com.kamaathedj.Graphql.service;

import com.kamaathedj.Graphql.model.LoginUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserService {
    public final static class UserServiceDetails extends LoginUser implements UserDetails {


        public UserServiceDetails(LoginUser user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> roles = AuthorityUtils.createAuthorityList("ROLE_LOGGER");
            if (this.isAdmin()) {
                roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

            } else {
                roles.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            return roles;

        }


        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }


    }
}
