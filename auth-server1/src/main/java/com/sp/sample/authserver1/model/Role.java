package com.sp.sample.authserver1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    private String role;



    @Override
    public String getAuthority() {
        return role;
    }
}
