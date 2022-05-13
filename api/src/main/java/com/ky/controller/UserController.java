package com.ky.controller;


import com.ky.ClassBrrowSystem.service.UserService;
import com.ky.ClassBrrowSystem.vo.ResultVo;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@ResponseBody
@RequestMapping("/user")
@Api(value = "用户登陆和管理接口",tags = "用户管理")
public class UserController  {

    @Resource
    private UserService uerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVo login(String userId,String pwd){
        return uerService.checkLogin(userId,pwd);
    }
}
