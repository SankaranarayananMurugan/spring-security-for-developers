package com.facadecode.spring.security.security;

import com.facadecode.spring.security.domain.AppUser;
import org.springframework.stereotype.Component;

import static com.facadecode.spring.security.enums.RoleEnum.INSTRUCTOR;

@Component("serviceSecurity")
public class ServiceSecurity {
    public Boolean isInstructor(AppUser appuser) {
        return appuser.getRoles()
                .stream()
                .anyMatch(appRole ->
                        appRole.getName().equals(INSTRUCTOR)
                );
    }
}
