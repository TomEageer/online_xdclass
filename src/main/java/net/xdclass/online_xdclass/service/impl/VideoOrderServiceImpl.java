package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.mapper.UserMapper;
import net.xdclass.online_xdclass.mapper.VideoMapper;
import net.xdclass.online_xdclass.mapper.VideoOrderMapper;
import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;


    @Autowired
    private VideoMapper videoMapper;


    /**
     * 下单操作
     * 未来版本：优惠券抵扣、风控用户检测、生成订单基础信息，生成支付信息。
     *
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    public int save(int userId, int videoId) {
//        判断是否已经购买

        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);
        if (videoOrder != null) {
            return 0;
        }

        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);

        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);

        return rows;
    }
}
