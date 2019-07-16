package com.career.genius.application.wechat.vo;

import com.career.genius.application.auth.dao.AuthUserInfoDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-07-16 15:38
 * @discription
 **/
@Data
@ApiModel(value = "微信分享")
public class WechatShareVO {

    @ApiModelProperty(value = "url")
    private String url;

    private AuthUserInfoDto userInfo;

    public WechatShareVO(String url, AuthUserInfoDto userInfo) {
        this.url = url;
        this.userInfo = userInfo;
    }
}
