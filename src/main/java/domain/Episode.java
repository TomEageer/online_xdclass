package domain;

import java.util.Date;

/**
 * `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 * `title` varchar(524) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '集标题',
 * `num` int NULL DEFAULT NULL COMMENT '第几集,全局顺序',
 * `ordered` int NULL DEFAULT NULL COMMENT '顺序，章里面的顺序',
 * `play_url` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '播放地址',
 * `chapter_id` int NULL DEFAULT NULL COMMENT '章节主键id',
 * `free` tinyint NULL DEFAULT 0 COMMENT '0表示免费，1表示首付',
 * `video_id` int NULL DEFAULT NULL COMMENT '视频id',
 * `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
 */
public class Episode {
    private Integer id;

    private String title;

    private Integer num;

    private Integer orderd;

    private String playUrl;

    private boolean free;

    private Integer videoId;

    private Date createTime;


    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num=" + num +
                ", orderd=" + orderd +
                ", playUrl='" + playUrl + '\'' +
                ", free=" + free +
                ", videoId=" + videoId +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getOrderd() {
        return orderd;
    }

    public void setOrderd(Integer orderd) {
        this.orderd = orderd;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}