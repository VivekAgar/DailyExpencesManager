package com.mycompany.dailyexpensemanager.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {


    Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        logger.info("An INFO Message VIVEK : "+ userName);
        System.out.println("VIVEK : "+ userName);
        Optional<User> user =  userRepository.findByFirstName(userName);
        logger.info("An INFO Message VIVEK : "+ userName);
        logger.trace("An INFO Message VIVEK : "+ userName);
        user.orElseThrow(()-> new UsernameNotFoundException("User Not Found " + userName));

        return user.map(MyUserDetails::new).get();
    }
}
