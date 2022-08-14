package com.facadecode.spring.security.repo;

import com.facadecode.spring.security.enums.RoleEnum;
import com.facadecode.spring.security.domain.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByName(RoleEnum name);
}
