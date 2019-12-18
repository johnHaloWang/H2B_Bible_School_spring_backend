package com.can2u.app.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.can2u.app.io.entity.UserRoleEntity;

@Repository
public interface UserRoleRepository extends PagingAndSortingRepository <UserRoleEntity, Long>{
	

}
