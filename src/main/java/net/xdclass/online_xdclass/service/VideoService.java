package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.domain.Video;
import net.xdclass.online_xdclass.domain.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(@Param("video_id")int videoId);
}
