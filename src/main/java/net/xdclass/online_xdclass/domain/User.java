package net.xdclass.online_xdclass.domain;

import java.util.Date;

/**
 *   `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '昵称',
 *   `pwd` varchar(124) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
 *   `head_img` varchar(524) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
 *   `phone` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '手机号',
 *   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
 */
public class User {

    private Integer id;

    private String name;

    private Integer pwd;

    private String headImg;

    private Integer phone;

    private Date createTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd=" + pwd +
                ", headImg='" + headImg + '\'' +
                ", phone=" + phone +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPwd() {
        return pwd;
    }

    public void setPwd(Integer pwd) {
        this.pwd = pwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}