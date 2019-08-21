package com.career.genius.application.wechat.dto;

import lombok.Data;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-08-21 10:37
 * @discription
 **/
@Data
public class WechatTokenDto {

    private String access_token;

    private String openId;
}
