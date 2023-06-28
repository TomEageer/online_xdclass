package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

public interface VideoOrderMapper {

    /**
     * 查询用户是否购买过商品
     *
     * @param userId
     * @param videoId
     * @param state
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    /**
     * 下单
     *
     * @param videoOrder
     * @return
     */
    int saveOrder(VideoOrder videoOrder);
}
