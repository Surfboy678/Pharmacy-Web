package com.brodacki.janusz.pharmacy.user.service;

import com.brodacki.janusz.pharmacy.user.model.User;
import com.brodacki.janusz.pharmacy.user.repository.UserRepository;
import com.brodacki.janusz.pharmacy.user.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        CustomUserDetails userDetails = null;

        if(user != null){
            userDetails = new CustomUserDetails();
            userDetails.setUser(user);

        }else {
            throw new UsernameNotFoundException("Email is not exist with name:" + email );
        }
        return userDetails;
    }
}
