package com.career.genius.application.wechat.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-07-16 15:31
 * @discription
 **/
@Data
@ApiModel(value = "获取微信授权")
public class WechatAuthVO {

    @ApiModelProperty(value = "签名")
    private String signTure;

    @ApiModelProperty(value = "时间戳")
    private String timestamp;

    @ApiModelProperty(value = "随即串")
    private String nonceStr;

    @ApiModelProperty(value = "appID")
    private String appId;

    public WechatAuthVO(String signTure, String timestamp, String nonceStr, String appId) {
        this.signTure = signTure;
        this.timestamp = timestamp;
        this.nonceStr = nonceStr;
        this.appId = appId;
    }

    public WechatAuthVO() {
    }
}
