package com.ky.ClassBrrowSystem.service.impl;

import com.ky.ClassBrrowSystem.dao.UserDAO;
import com.ky.ClassBrrowSystem.enity.User;
import com.ky.ClassBrrowSystem.service.UserService;
import com.ky.ClassBrrowSystem.vo.ResultVo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

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

                HashMap<String,Object> map = new HashMap<>();

                JwtBuilder builder = Jwts.builder();
                 String token = builder.setSubject(user.getUserId() + "," + user.getUsername())
                        .setIssuedAt(new Date())                //设置生成时间
                        .setId(user.getUserId())                //设置用户Id为tokenId
                        .setClaims(map)                         //map中可以存放用户角色等信息
                        .setExpiration(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000))//设置过期时间2小时有效
                        .signWith(SignatureAlgorithm.HS256, "SDUTCCSTRBS")                    //设置加密方式和密码，要想解密token必须先提供密码
                        .compact();

            returnUser.setToken(token);
                return new ResultVo(200,"登陆成功",returnUser);
            }else {
                //验证失败
                return new ResultVo(400,"密码错误",null);
            }
        }
    }
}
