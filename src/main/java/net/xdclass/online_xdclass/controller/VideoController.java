package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.domain.Video;
import net.xdclass.online_xdclass.domain.VideoBanner;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 轮播图列表
      * @return
     */
    @GetMapping("list_banner")
    public JsonData indexBanner() {

        List<VideoBanner> bannerList = videoService.listBanner();

        return JsonData.buildSuccess(bannerList);
    }

    /**
     * 视频列表
     * @return
     */
    @RequestMapping("list")
    public Object listVideo() {

        List<Video> videoList = videoService.listVideo();
        return videoService.listVideo();
    }
}