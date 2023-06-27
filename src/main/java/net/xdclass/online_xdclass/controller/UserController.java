package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.model.request.LoginRequest;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {

        try {
            int rows = userService.save(userInfo);
            if (rows == 1) {
                return JsonData.buildSuccess("注册成功");
            }
            return null;
        } catch (Exception e) {
            return JsonData.buildError("名称或手机号码已存在");
        }
    }


    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest) {

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());

        System.out.println("UserController的login的token："+token);

        return token == null ? JsonData.buildError("登陆失败，账号密码错误") : JsonData.buildSuccess(token);
    }

    /**
     * 根据用户id查询信息
     *
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");

        if (userId == null) {
            return JsonData.buildError("查询失败");
        }

        User user = userService.findByUserId(userId);

        return JsonData.buildSuccess(user);
    }


}
