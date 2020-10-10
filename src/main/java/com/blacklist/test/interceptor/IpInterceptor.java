package com.blacklist.test.interceptor;

import com.blacklist.test.util.IpAddressUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IpInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在调用接口前对ip进行查验
        String ip = IpAddressUtil.getIpAddress(request);
        return checkIp(ip);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //在Controller被调用后核验ip访问次数
        //获取ip
        String ip = IpAddressUtil.getIpAddress(request);
        //核验ip访问次数

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public void checkUrl(){
        //该方法核验ip访问次数
        //如访问次数超过限定范围，将ip存到Redis的ip黑名单中
        //通过抛出错误，不让程序进行下去
    }

    public boolean checkIp(String ip){
        //通过Redis对比ip
        //如在黑名单中发现相同ip，返回false
        return true;
    }
}
