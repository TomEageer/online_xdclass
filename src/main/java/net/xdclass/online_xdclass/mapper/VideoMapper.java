package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;

import java.util.List;

public interface VideoMapper {

    /**
     * 查询视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     * 首页轮播图列表
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 查询视频详情
     * @param videoId
     * @return
     */
    Video findDetailById(int videoId);
}