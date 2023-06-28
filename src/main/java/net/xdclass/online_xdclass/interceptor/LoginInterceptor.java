package net.xdclass.online_xdclass.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import javafx.beans.binding.ObjectExpression;
import net.xdclass.online_xdclass.utils.JWTUtils;
import net.xdclass.online_xdclass.utils.JsonData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.management.ObjectName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.cert.Extension;

/**
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入到Controller之前到方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入了登陆拦截器");
        try {
            String accessToken = request.getHeader("token");
            if (accessToken == null) {
                System.out.println("\n=================Header为空重新获取token=================\n");
                accessToken = request.getParameter("token");
            }

            if (StringUtils.isNotBlank(accessToken)) {

                Claims claims = JWTUtils.checkJWT(accessToken);
                System.out.println("\ntoken检测到了解密后结果：" + claims + "\n");
                if (claims == null) {
                    //告诉登陆过期
                    System.out.println("\n=================登陆拦截器检测到claims为空=================\n");
                    sendJsonMessage(response, JsonData.buildError("22登陆过期， 重新登陆"));
                    return false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");
                System.out.println("\n=================获取到了id和name=================" + "id:" + id + "  name:" + name + "\n");

                request.setAttribute("user_id", id);//把userId返回到了request请求中
                request.setAttribute("name", name);

                return true;
            }

        } catch (Exception e) {
            //login error

        }
        sendJsonMessage(response, JsonData.buildError("11登陆过期， 重新登陆"));

        return false;
    }


    /**
     * 响应json数据给前端，复习一下，没懂干嘛的
     *
     * @param response
     * @param obj
     */
    public static void sendJsonMessage(HttpServletResponse response, Object obj) {

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));

            writer.close();

            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
