package com.facadecode.spring.security.security;

import org.springframework.security.access.PermissionEvaluator;

public interface PermissionEvaluatorStrategy<T> extends PermissionEvaluator {
    <T> Class<T> getTargetType();
}
