package com.mycompany.dailyexpensemanager.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    Logger logger = LoggerFactory.getLogger(MyUserDetails.class);
    private String userName;
    private String password;
    private Boolean active;
    private List<GrantedAuthority> authorityList;

    public MyUserDetails(){
    }


    public MyUserDetails(User user) {
        logger.info("in constructor MyUserDetails VIVEK : "+ user.getEmail());
        logger.info("in constructor MyUserDetails VIVEK : "+ user.getEnabled());
        logger.info("in constructor MyUserDetails VIVEK : "+ user.getPassword());
        logger.info("in constructor MyUserDetails VIVEK : "+ user.getFirstName());

        this.active = user.getEnabled();
        this.userName = user.getFirstName();
        this.password = user.getPassword();
        this.active = user.getEnabled();
        this.authorityList = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        logger.info("in constructor MyUserDetails VIVEK : "+ this.authorityList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }




}
