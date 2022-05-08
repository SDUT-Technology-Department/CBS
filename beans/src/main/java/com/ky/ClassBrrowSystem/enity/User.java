package com.ky.ClassBrrowSystem.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int UserId;
    private String userName;
    private String password;
}

