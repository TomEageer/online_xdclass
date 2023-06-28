package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.mapper.*;
import net.xdclass.online_xdclass.model.entity.Episode;
import net.xdclass.online_xdclass.model.entity.PlayRecord;
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

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;

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
        System.out.println("\n=========进入了save实现类===========\n");

        System.out.println("\n=========videoId:" + videoId + " userId:" + userId + "=========\n");
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);
        if (videoOrder != null) {
            System.out.println("\n=========videoOrder已存在=========\n");
            return 0;
        }

        System.out.println("\n=========videoOrder:" + videoOrder + "=========\n");
        Video video = videoMapper.findById(videoId);

        System.out.println("\n=========video:" + video + "=========\n");

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
        System.out.println("\n=======rows" + rows + " newVideoOrder:" + newVideoOrder + "=========\n");
        if (rows == 1) {

            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);

            PlayRecord playRecord = new PlayRecord();

            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecordMapper.saveRecord(playRecord);
        }


        return rows;
    }
}
