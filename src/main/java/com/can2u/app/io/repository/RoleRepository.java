package com.can2u.app.io.repository;




import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.can2u.app.io.entity.RoleEntity;



@Repository
public interface RoleRepository extends PagingAndSortingRepository <RoleEntity, Long>{

	RoleEntity findByRoleName(String roleNames);
	RoleEntity findByRoleId(String RoleId);

}
