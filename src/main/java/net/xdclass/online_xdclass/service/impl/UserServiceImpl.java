package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.mapper.UserMapper;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.utils.CommonUtils;
import net.xdclass.online_xdclass.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(Map<String, String> userInfo) {

        User user = parseToUser(userInfo);
        if (user != null) {

            return userMapper.save(user);
        } else {
            return -1;
        }
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {

        User user = userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
        System.out.println("\n============UserServiceImpl的token封装前User：" + user+"============\n");
        if (user == null) {
            return null;
        } else {
            String token = JWTUtils.geneJsonWebToken(user);//把user的传来的数据封装成一个token
            System.out.println("\n============封装后的token:" + token+"==========\n");

            return token;
        }

    }

    @Override
    public User findByUserId(Integer userId) {
        System.out.println("\n==========UserService的检查" + userId + "\n");
        User user = userMapper.findByUserId(userId);

        //user.setPwd("");
        System.out.println("\n==========UserService的检查：User:" + user + "\n");
        return user;
    }


    /**
     * 解析user对象
     *
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String, String> userInfo) {

        if (userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")) {
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            user.setPhone(userInfo.get("phone"));
            String pwd = userInfo.get("pwd");
            //md5加密
            user.setPwd(CommonUtils.MD5(pwd));

            return user;
        } else {
            System.out.println("\nMD5加密失败\n");
            return null;
        }
    }

    /**
     * 放在CDN上的随即头像
     */
    private static final String[] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };


    private String getRandomImg() {
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);

        return headImg[index];
    }


}
