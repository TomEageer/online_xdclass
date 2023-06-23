package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int save(User user);

    User findByPhone(@Param("phone") String phone);


}
