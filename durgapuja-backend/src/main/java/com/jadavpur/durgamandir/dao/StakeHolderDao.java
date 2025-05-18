package com.jadavpur.durgamandir.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jadavpur.durgamandir.model.StakeHolder;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface StakeHolderDao extends JpaRepository<StakeHolder, Integer> {
	

}
