package com.career.genius.application.auth.dto;

import com.career.genius.utils.jdbcframework.ColumnAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-05-31 15:21
 * @discription
 **/
@ApiModel(value = "用户信息DTO")
@Data
public class AuthUserInfoDto implements Serializable {

    @ApiModelProperty(value = "用户ID")
    @ColumnAlias(value = "id")
    private String userId;

    @ApiModelProperty(value = "用户名")
    @ColumnAlias(value = "user_name")
    private String userName;

    @ApiModelProperty(value = "电话")
    @ColumnAlias(value = "phone")
    private String phone;

    @ApiModelProperty(value = "头像")
    @ColumnAlias(value = "head_image")
    private String headImage;

    @ApiModelProperty(value = "openId")
    @ColumnAlias(value = "open_id")
    private String openId;

    @ApiModelProperty(value = "所属行业")
    @ColumnAlias(value = "trade")
    private String trade;
}
