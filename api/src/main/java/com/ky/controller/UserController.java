package com.ky.controller;


import com.ky.ClassBrrowSystem.service.UserService;
import com.ky.ClassBrrowSystem.vo.ResultVo;
import io.swagger.annotations.Api;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/user")
@Api(value = "用户登陆和管理接口",tags = "用户管理")
@CrossOrigin
public class UserController  {

    @Resource
    private UserService uerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo login(@RequestBody JSONObject jsonParam){

        System.out.println(jsonParam);

        Map<String,Object> map =new HashMap<>();
        //开始转换
        String userId = jsonParam.getAsString("userId");
        String pwd = jsonParam.getAsString("pwd");

        System.out.println(userId);
        System.out.println(pwd);
        return uerService.checkLogin(userId,pwd);
    }
}
