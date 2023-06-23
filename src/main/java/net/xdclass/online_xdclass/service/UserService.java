package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserService {
    /**
     *xinzeng
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);

    String findByPhoneAndPwd(@Param("phone") String phone,@Param("pwd") String pwd);
}

