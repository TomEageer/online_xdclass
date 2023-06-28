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

        System.out.println("/n==============================/api/v1/pri/user/login===========================================/n");
        System.out.println("/n===============获取的手机号码" + loginRequest.getPhone() + "获取到的密码：" + loginRequest.getPwd() + "/n");

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());

        System.out.println("UserController的login的token：" + token);

        return token == null ? JsonData.buildError("登陆失败，x账号密码错误") : JsonData.buildSuccess(token);
    }

    /**
     * 根据用户id查询信息
     *
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request) {

        System.out.println("\n==============================/api/v1/pri/user/find_by_token===========================================\n");
        Integer userId = (Integer) request.getAttribute("user_id");

        if (userId == null) {
            System.out.println("\n==============userId为空，可能是拦截器中没有获取到请求体中的userId的参数==============\n");
            return JsonData.buildError("查询失败，userId为空");
        }

        System.out.println("\n==============userId获取到了，userId：" + userId + "==============\n");

        User user = userService.findByUserId(userId);

        return JsonData.buildSuccess(user);
    }


}
