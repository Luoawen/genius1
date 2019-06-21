package com.career.genius.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-05-29 10:18
 * @discription
 **/
@Component
@Configuration
@PropertySource("classpath:templates/config-${spring.profiles.active}.properties")
public class BaseConfigProperties {

    public static String accessToken;

    public static String androidSalt;

    public static String iosSalt;

    public static String aliyunSignName;

    public static String aliyunTemplateCode;

    public static String aliyunAccessKey;

    public static String aliyunAccessSecret;


    @Value("${android_salt}")
    public void setAndroidSalt(String androidSalt) {
        this.androidSalt = androidSalt;
    }

    @Value("${ios_salt}")
    public void setIosSalt(String iosSalt) {
        this.iosSalt = iosSalt;
    }

    @Value("${access_token}")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Value("${aliyun_sign_name}")
    public void setAliyunSignName(String aliyunSignName) {
        this.aliyunSignName = aliyunSignName;
    }

    @Value("${aliyun_template_code}")
    public void setAliyunTemplateCode(String aliyunTemplateCode) {
        this.aliyunTemplateCode = aliyunTemplateCode;
    }

    @Value("${aliyun_access_key}")
    public void setAliyunAccessKey(String aliyunAccessKey) {
        this.aliyunAccessKey = aliyunAccessKey;
    }

    @Value("${aliyun_access_secret}")
    public void setAliyunAccessSecret(String aliyunAccessSecret) {
        this.aliyunAccessSecret = aliyunAccessSecret;
    }
}
