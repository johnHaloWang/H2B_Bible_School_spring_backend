package com.can2u.app.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.can2u.app.io.entity.*;

@Repository
public interface UserRepository extends PagingAndSortingRepository <UserEntity, Long> {
	
	UserEntity findByEmail(String email);
	UserEntity findByUserId(String userId);
	
	
	
}
