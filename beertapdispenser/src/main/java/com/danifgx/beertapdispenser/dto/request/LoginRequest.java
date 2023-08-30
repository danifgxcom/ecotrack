package com.danifgx.beertapdispenser.dao.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;

    // Getters y setters
}