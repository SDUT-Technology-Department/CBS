package com.ky.ClassBrrowSystem.service;

import com.ky.ClassBrrowSystem.vo.ResultVo;

public interface UserService {
    public ResultVo checkLogin(String userId, String pwd);
}
