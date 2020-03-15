package com.brodacki.janusz.pharmacy.user.repository;

import com.brodacki.janusz.pharmacy.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String userName);
}
