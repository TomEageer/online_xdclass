package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        System.out.println("\n==============================api/v1/pub/video/list_banner===========================================\n");

        List<VideoBanner> bannerList = videoService.listBanner();

        return JsonData.buildSuccess(bannerList);
    }

    /**
     * 视频列表
     * @return
     */
    @RequestMapping("list")
    public Object listVideo() {


        System.out.println("\n=============================api/v1/pub/video/list==========================================\n");
        List<Video> videoList = videoService.listVideo();
        return videoService.listVideo();
    }

    /**
     * 查询视频列表详情，包含章、集、信息
     * @param videoId
     * @return
     */
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id", required = true)int videoId){

        System.out.println("\n==============================api/v1/pub/video/find_detail_by_id===========================================\n");
        Video video = videoService.findDetailById(videoId);

        return JsonData.buildSuccess(video);
    }
}