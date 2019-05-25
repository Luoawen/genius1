package com.career.genius.config.auth.vo;

import com.career.genius.utils.MsgCodeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by alankin on 2018/12/30.
 */
@ApiModel(value = "UserReqVo", description = "")
@Data
public class UserReqVo {

    @ApiModelProperty(value = "电话", example = "13900000000")
    @NotEmpty(message = "请输入手机号码")
    @NotNull(message = "请输入手机号码")
    @Pattern(regexp = "^1[0-9][0-9]\\d{8}$", message = "请输入正确的电话号码")
    String phone;
    @ApiModelProperty(value = "短信验证码", example = "2222")
    @NotEmpty(message = "请填写短信验证码")
    @Length(min = MsgCodeUtil.MSG_CODE_NUM, max = MsgCodeUtil.MSG_CODE_NUM, message = "请输入" + MsgCodeUtil.MSG_CODE_NUM + "位短信验证码")
    String phoneCode;
    @ApiModelProperty(value = "密码", example = "123")
//    @NotBlank(message = "密码不能为空")
    String password;

}
