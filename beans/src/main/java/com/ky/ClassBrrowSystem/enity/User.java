package com.ky.ClassBrrowSystem.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;
    private String username;
    private String password;
    private String uClass;
    private String role;
    private String contact;
    private String department;
    private String token;
}

