package com.ky.ClassBrrowSystem.service.impl;

import com.ky.ClassBrrowSystem.dao.UserDAO;
import com.ky.ClassBrrowSystem.enity.User;
import com.ky.ClassBrrowSystem.service.UserService;
import com.ky.ClassBrrowSystem.vo.ResultVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;
    @Override
    public ResultVo checkLogin(String userId, String pwd){
        //查询用户信息
        User user = userDAO.checkLogin(userId);
        User returnUser = userDAO.queryUserById(userId);
        //判断
        if (user == null){
            //用户名不存在
            return new ResultVo(400,"用户名不存在，请联系管理员注册",null);
        }else {
            //对密码加密

            //使用加密后的密码与user中的密码进行匹配
            if (user.getPassword().equals(pwd) ){
                //验证成功
                return new ResultVo(200,"登陆成功",returnUser);
            }else {
                //验证失败
                return new ResultVo(400,"密码错误",null);
            }
        }
    }
}
