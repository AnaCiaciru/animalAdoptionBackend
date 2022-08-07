package com.animal.adoption.repository;

import java.util.Optional;

import com.animal.adoption.models.ERole;
import com.animal.adoption.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
