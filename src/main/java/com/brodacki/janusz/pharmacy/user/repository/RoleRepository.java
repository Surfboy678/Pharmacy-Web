package com.brodacki.janusz.pharmacy.user.repository;

import com.brodacki.janusz.pharmacy.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);

}

