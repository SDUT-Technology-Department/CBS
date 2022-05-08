package com.ky.ClassBrrowSystem.dao;

import com.ky.ClassBrrowSystem.enity.User;

public interface UserDAO {
    public User queryUserByName(String Name);
}