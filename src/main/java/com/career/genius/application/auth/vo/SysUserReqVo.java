package com.career.genius.application.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by alankin on 2018/12/30.
 */
@ApiModel(value = "SysUserReqVo", description = "")
public class SysUserReqVo {

    @ApiModelProperty(value = "电话", example = "13900000000")
    @NotBlank(message = "电话不能为空")
    String phone;

    @ApiModelProperty(value = "验证码", example = "1111")
    @NotBlank(message = "验证码不能为空")
    String authCode;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

}
