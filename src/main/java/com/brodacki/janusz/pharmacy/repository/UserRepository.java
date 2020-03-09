package com.brodacki.janusz.pharmacy.repository;

import com.brodacki.janusz.pharmacy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
