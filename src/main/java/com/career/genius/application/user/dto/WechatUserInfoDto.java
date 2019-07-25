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

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "微信用户名")
    private String userName;

    @ApiModelProperty(value = "微信头像")
    private String headImage;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "微信uniqueId")
    private String uniqueId;
}
