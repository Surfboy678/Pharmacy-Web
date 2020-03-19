package com.brodacki.janusz.pharmacy.user.service;

import com.brodacki.janusz.pharmacy.user.model.User;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);
}