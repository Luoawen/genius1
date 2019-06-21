package com.career.genius.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.career.genius.config.Exception.GeniusException;
import com.career.genius.config.properties.BaseConfigProperties;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-05-24 14:17
 * @discription
 **/
@Slf4j
@Service
public class SendSms {

    // 产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    public static void sendSms(String phone, HttpServletRequest servletRequest) throws GeniusException {
        DefaultProfile profile = DefaultProfile.getProfile("default", BaseConfigProperties.aliyunAccessKey, BaseConfigProperties.aliyunAccessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", BaseConfigProperties.aliyunSignName);
        request.putQueryParameter("TemplateCode", BaseConfigProperties.aliyunTemplateCode);
        String randomValue = getRandomValue();
        request.putQueryParameter("TemplateParam", "{\"code\":\""+ randomValue + "\"}");
        HttpSession session = servletRequest.getSession();
        try {
            CommonResponse response = client.getCommonResponse(request);
            MsgCodeUtil.saveCode(session, phone, randomValue);
            log.info("发送的手机号：{}",phone);
            JSONObject json = (JSONObject) JSONObject.parse(response.getData());
            if (!json.getString("Code").equalsIgnoreCase("OK")) {
                throw new GeniusException(json.getString("Message"));
            }
            log.info("短信发送结果---------------->{}",json.toJSONString());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取4位随机数
     * @return
     */
    private static String getRandomValue() {
        String str="0123456789";
        StringBuilder sb=new StringBuilder(4);
        for(int i = 0; i < 4; i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

}
