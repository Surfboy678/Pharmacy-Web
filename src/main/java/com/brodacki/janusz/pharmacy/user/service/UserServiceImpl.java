package com.brodacki.janusz.pharmacy.user.service;


import com.brodacki.janusz.pharmacy.email.model.Mail;
import com.brodacki.janusz.pharmacy.email.service.SimpleEmailService;
import com.brodacki.janusz.pharmacy.user.model.User;
import com.brodacki.janusz.pharmacy.user.repository.RoleRepository;
import com.brodacki.janusz.pharmacy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SimpleEmailService emailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private static final String SUBJECT = "Register: your account is active";

    @Override
    public void saveUser(User user) {
        String userName = user.getUsername();
        String userEmail = user.getEmail();
        String pwd = user.getPassword();
        String encryptPwd = bCryptPasswordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        user.setActive(1);
        user.setRoles(roleRepository.findByRole("ROLE_USER"));

        emailService.send(new Mail(userEmail,
                "",
                SUBJECT + " " + userName,
                "new user" + userName + "has been register"
        ));
        userRepository.save(user);
    }
}
