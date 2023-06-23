package net.xdclass.online_xdclass.controller;


import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {


    /**
     *下单接口
     * @return
     */
    @RequestMapping("save")
    public JsonData saveOrder(){



        return JsonData.buildSuccess();
    }

}
