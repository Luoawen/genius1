package com.career.genius.config.sys;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

/**
 * Access_Token校验拦截器
 */
@Service
@Slf4j
public class AcTokenInterCeptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Request url------------------->" + request.getRequestURL());

        //设定路径不拦截
        if (notInterCeptUri().contains(request.getRequestURI())) {
            return true;
        }
        /** 签名加密校验*/
        /*String checkResult = signCheck(request);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (!StringUtils.isEmpty(checkResult)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 403005);
            map.put("msg", "URL签名错误");
            PrintWriter writer = response.getWriter();
            JSONObject result = (JSONObject) JSONObject.toJSON(map);
            writer.println(result);
            return false;
        }*/
        return true;
    }

    /**
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

        /*ServletOutputStream stream = response.getOutputStream();
        MResult result = new MResult(403001,"invalid access_token");
        Object json = JSONObject.toJSON(request);
        stream.println(json.toString());*/
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }


    /**
     * 功能描述: 不需要拦截的路径
     *
     * @auther: luoqw
     * @date: 2018/5/28 11:15
     */
    public List<String> notInterCeptUri() {
        List<String> uris = new ArrayList<>();
        uris.add("/udsapp/devices/classify");           //查询设备分类
        uris.add("/udsapp/u-push/test");                 //友盟消息推送测试路径
        uris.add("/udsapp/devices/message");            //绿米设备消息接收服务器
        uris.add("/udsapp/hello");                      //测试路径

        return uris;
    }

    /**
     * 功能描述:  移动端签名校验
     *
     * @auther: luoqw
     * @date: 2018/6/20 15:58
     */
    public String signCheck(HttpServletRequest request) throws Exception {
        TreeMap<String, Object> map = new TreeMap<>();
        Enumeration<String> paraNames = request.getParameterNames();
        for (Enumeration<String> e = paraNames; e.hasMoreElements(); ) {
            String thisKey = e.nextElement();
            String thisValue = request.getParameter(thisKey);
            map.put(thisKey, thisValue);
        }
        String sign = "";

        if (!request.getParameter("sign").equals(sign)) {
            log.info("签名错误...");
            return "error";

        }
        return null;
    }


}
