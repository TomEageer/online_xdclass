package domain;

import java.util.Date;

/**
 *
 *   `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `title` varchar(524) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '视频标题',
 *   `summary` varchar(1026) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '概述',
 *   `cover_img` varchar(524) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面图',
 *   `price` int NULL DEFAULT NULL COMMENT '价格,分',
 *   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
 *   `point` double(11, 2) NULL DEFAULT 8.70 COMMENT '默认8.7，最高10分',
 */
public class Video {

    private Integer id;

    private String title;

    private String summary;

    private String coverImg;

    private Integer Price;

    private Date createTime;

    private double point;

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", Price=" + Price +
                ", createTime=" + createTime +
                ", point=" + point +
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
