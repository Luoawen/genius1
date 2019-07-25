package com.career.genius.application.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-07-09 12:46
 * @discription
 **/
@ApiModel(value = "绑定微信用户")
@Data
public class WechatUserInfoDto {

    @ApiModelProperty(name = "用户ID")
    private String userId;

    @ApiModelProperty(name = "微信用户名")
    private String userName;

    @ApiModelProperty(name = "微信头像")
    private String headImage;

    @ApiModelProperty(name = "openId")
    private String openId;

    @ApiModelProperty(name = "手机号")
    private String phone;

    @ApiModelProperty(name = "微信uniqueId")
    private String uniqueId;
}
