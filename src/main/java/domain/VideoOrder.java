package domain;

import java.util.Date;

/**
 * `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 * `out_trade_no` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '订单唯一标识',
 * `state` int NULL DEFAULT NULL COMMENT '0表示未支付，1表示已支付',
 * `create_time` datetime NULL DEFAULT NULL COMMENT '订单生成时间',
 * `total_fee` int NULL DEFAULT NULL COMMENT '支付金额，单位分',
 * `video_id` int NULL DEFAULT NULL COMMENT '视频主键',
 * `video_title` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '视频标题',
 * `video_img` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '视频图片',
 * `user_id` int NULL DEFAULT NULL COMMENT '用户id',
 */
public class VideoOrder {
    private Integer id;

    private String outTradeNo;

    private Integer state;

    private Date createTime;

    private Integer totalFee;

    private Integer videoId;

    private String videoTitle;

    private String videoImg;

    private Integer userId;

}
