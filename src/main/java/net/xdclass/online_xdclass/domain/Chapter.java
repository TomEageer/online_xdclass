package net.xdclass.online_xdclass.domain;

import java.util.Date;

/**
 * `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 * `video_id` int NULL DEFAULT NULL COMMENT '视频主键',
 * `title` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '章节名称',
 * `ordered` int NULL DEFAULT NULL COMMENT '章节顺序',
 * `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
 */
public class Chapter {
    private Integer id;

    private Integer videoId;

    private String title;

    private Integer ordered;

    private Date createTime;


    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", title='" + title + '\'' +
                ", ordered=" + ordered +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
