package net.xdclass.online_xdclass.config;

import net.xdclass.online_xdclass.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 拦截器配置
 * <p>
 * 不用权限    /api/v1/pub
 * 要登陆权限  /api/v1/pri
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //拦截全部
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                //不拦截那些路径
                .excludePathPatterns("/api/v1/pri/user/login", "/api/v1/pri/user/register");

        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
