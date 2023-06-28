package net.xdclass.online_xdclass.controller;


import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.model.request.VideoOrderRequest;
import net.xdclass.online_xdclass.service.VideoOrderService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;

    /**
     * 下单接口
     *
     * @return
     */
    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request) {
        System.out.println("\n============进入了saveOrder===========\n");
        Integer userId = (Integer) request.getAttribute("user_id");
        System.out.println("\n===============userId：" + userId + "================\n");

        int rows = videoOrderService.save(userId, videoOrderRequest.getVideoId());

        System.out.println("\n===========rows的值：" + rows + "===========\n");
        return rows == 0 ? JsonData.buildError("下单失败") : JsonData.buildSuccess();

    }

}
