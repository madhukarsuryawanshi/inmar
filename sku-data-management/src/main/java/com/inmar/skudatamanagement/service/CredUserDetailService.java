package com.inmar.skudatamanagement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class CredUserDetailService implements UserDetailsService {
    /*@Autowired
    CredentialRepo credentialRepo;*/

    @Value("${cred.username}")
    String userName;

    @Value("${cred.password}")
    String password;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("Username: {} and Password: {} ", userName, password);
        return new User(userName, password, new ArrayList<>());
    }
}
