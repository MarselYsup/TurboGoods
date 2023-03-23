package com.my.turbogoods.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    CUSTOMER,
    COURIER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
