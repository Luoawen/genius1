package com.career.genius.controller.auth;

import com.career.genius.application.auth.AuthApplication;
import com.career.genius.application.auth.vo.SysUserReqVo;
import com.career.genius.config.Exception.GeniusException;
import com.career.genius.config.auth.vo.UserReqVo;
import com.usm.enums.CodeEnum;
import com.usm.vo.BaseResultDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-05-24 14:13
 * @discription
 **/
@RestController
@Slf4j
@RequestMapping(value = "/users")
@ApiModel(value = "用户接口")
public class AuthController {

    @Autowired
    AuthApplication authApplication;

    @ApiOperation(value = "发送短信验证码")
    @RequestMapping(value = "/message",method = RequestMethod.POST)
    public BaseResultDto sendMsgCode(HttpServletRequest request, @RequestBody UserReqVo vo) throws Exception{
        authApplication.sendSms(request,vo.getPhone());
        return new BaseResultDto(CodeEnum.Success.getCode(),"短信发送成功");
    }

    @ApiOperation(value = "注册/登陆")
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public BaseResultDto signin(HttpServletRequest request, @Valid @RequestBody SysUserReqVo vo) throws GeniusException {
        HttpSession session = request.getSession();
        authApplication.registOrLogin(vo,session);
        // 校验通过后删除验证码之前的session和Cookie
        if (session != null) {
            session.invalidate();
        }
        return new BaseResultDto(CodeEnum.Success.getCode(),"登陆成功");
    }


}
