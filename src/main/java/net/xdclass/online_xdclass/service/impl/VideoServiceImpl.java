package net.xdclass.online_xdclass.service.impl;

import javafx.geometry.VerticalDirection;
import net.xdclass.online_xdclass.config.CacheKeyManager;
import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.mapper.VideoMapper;
import net.xdclass.online_xdclass.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import net.xdclass.online_xdclass.service.VideoService;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {
        try {
            Object object = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST_KEY, () -> {
                List<Video> videoList = videoMapper.listVideo();
                System.out.println("\n=========Guava缓存开启==========\n");
                return videoList;
            });

            if (object instanceof List){
                List<Video> videoList = (List<Video>) object;
                System.out.println("\n判断obejct是否存在东西了");
                return videoList;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("\nImpl的listVedio出了问题\n");
        return null;
    }

    @Override
    public List<VideoBanner> listBanner() {
        try {
            Object object = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_LIST_KEY, () -> {
                List<VideoBanner> bannerList = videoMapper.listVideoBanner();
                System.out.println("\n=============Guava缓存开启===============\n");
                return bannerList;
            });

            if (object instanceof List) {
//            if (object != null) { 后边看看这么写会发生什么问题
                List<VideoBanner> bannerList = (List<VideoBanner>) object;
                return bannerList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {

        try {
            Object object = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, () -> {
                Video video = videoMapper.findDetailById(videoId);
                System.out.println("\nvideoId:"+videoId+"\n");
                System.out.println("\n=============Guava缓存开启===============\n");
                return video;
            });

            if (object instanceof Video) {
                System.out.println("判断obejct是否存在东西了");
                Video video = (Video) object;
                return video;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
//        Video video = videoMapper.findDetailById(videoId);
//
//        return video;

    }
}
