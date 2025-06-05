package com.hctt.is208.authentication.DTO;

import lombok.Data;

@Data
public class SignUpDTO {
    private String loginName;
    private String passwordHash;
    private String name;
    private String email;
}
