package com.jadavpur.durgamandir.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jadavpur.durgamandir.security.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	
    Optional<Users> findByUsername(String username);
}