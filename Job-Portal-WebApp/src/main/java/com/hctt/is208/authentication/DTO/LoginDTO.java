package com.hctt.is208.authentication.DTO;

import lombok.Data;

@Data
public class LoginDTO {
    private String loginName;
    private String passwordHash;
}
