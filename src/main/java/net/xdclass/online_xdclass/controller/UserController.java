package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.request.LoginRequest;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import net.xdclass.online_xdclass.mapper.UserMapper;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("register")
    public JsonData register (@RequestBody Map<String, String> userInfo){

        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("注册失败");
    }

    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());

        return token == null ? JsonData.buildError("登陆失败，账号密码错误"): JsonData.buildSuccess(token);
    }


}
