package com.jadavpur.durgamandir.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jadavpur.durgamandir.security.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
