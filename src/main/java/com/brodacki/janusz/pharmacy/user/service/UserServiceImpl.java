package com.brodacki.janusz.pharmacy.user.service;

import com.brodacki.janusz.pharmacy.user.model.Role;
import com.brodacki.janusz.pharmacy.user.model.User;
import com.brodacki.janusz.pharmacy.user.repository.RoleRepository;
import com.brodacki.janusz.pharmacy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        String pwd = user.getPassword();
        String encryptPwd = bCryptPasswordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        user.setActive(1);
        user.setRoles(roleRepository.findByRole("ROLE_USER"));
        userRepository.save(user);
    }
}
