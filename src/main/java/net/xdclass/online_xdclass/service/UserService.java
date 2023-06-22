package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserService {
    /**
     *xinzeng
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);

//    User findByPhone(@Param("phone") String phone);
}
