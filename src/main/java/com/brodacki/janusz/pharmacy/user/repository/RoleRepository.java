package com.brodacki.janusz.pharmacy.user.repository;

import com.brodacki.janusz.pharmacy.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByRole(String role);

}

