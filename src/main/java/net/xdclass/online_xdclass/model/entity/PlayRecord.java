package net.xdclass.online_xdclass.model.entity;


// TABLE `play_record` (
//         `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
//         `user_id` int(11) DEFAULT NULL,
//         `video_id` int(11) DEFAULT NULL,
//         `current_num` int(11) DEFAULT NULL COMMENT '当前播放第⼏集',
//         `episode_id` int(11) DEFAULT NULL COMMENT '当前播放第⼏集视频id',
//         `create_time` datetime DEFAULT NULL,
//         PRIMARY KEY (`id`)
//         ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;
import java.util.Date;

public class PlayRecord {

    private Integer id;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("video_id")
    private Integer videoId;

    @JsonProperty("current_num")
    private Integer currentNum;

    @JsonProperty("episode_id")
    private Integer episodeId;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PlayRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", videoId=" + videoId +
                ", currentNum=" + currentNum +
                ", episodeId=" + episodeId +
                ", createTime=" + createTime +
                '}';
    }
}