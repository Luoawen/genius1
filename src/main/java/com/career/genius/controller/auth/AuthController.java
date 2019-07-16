package com.career.genius.controller.auth;

import com.career.genius.application.auth.AuthApplication;
import com.career.genius.application.auth.dao.AuthUserInfoDto;
import com.career.genius.application.auth.query.AuthUserQuery;
import com.career.genius.application.auth.vo.SysUserReqVo;
import com.career.genius.config.Exception.GeniusException;
import com.career.genius.application.auth.vo.UserReqVo;
import com.usm.enums.CodeEnum;
import com.usm.vo.BaseResultDto;
import com.usm.vo.EntityDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
@Api(tags = "登陆/注册接口")
public class AuthController {

    @Autowired
    AuthApplication authApplication;

    @Autowired
    AuthUserQuery authUserQuery;

    @ApiOperation(value = "发送短信验证码")
    @RequestMapping(value = "/message",method = RequestMethod.POST)
    public BaseResultDto sendMsgCode(HttpServletRequest request, @RequestBody UserReqVo vo) throws Exception{
        authApplication.sendSms(request,vo.getPhone());
        return new BaseResultDto(CodeEnum.Success.getCode(),"短信发送成功");
    }

    @ApiOperation(value = "注册/登陆")
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public EntityDto<AuthUserInfoDto> signin(HttpServletRequest request, @Valid @RequestBody SysUserReqVo vo) throws GeniusException {
        HttpSession session = request.getSession();
        authApplication.registOrLogin(vo,session);
        // 校验通过后删除验证码之前的session和Cookie
       /* if (session != null) {
            session.invalidate();
        }*/
        AuthUserInfoDto infoDto = authUserQuery.queryForUser(vo.getPhone());
        session.setAttribute("userInfo",infoDto);
        return new EntityDto<>(infoDto,CodeEnum.Success.getCode(),"成功");
    }

    @ApiOperation(value = "获取用户基本信息")
    @RequestMapping(value = "/user/{phone}",method = RequestMethod.GET)
    public EntityDto<AuthUserInfoDto> getUserInfo(@PathVariable("phone") String phone) throws GeniusException {
        AuthUserInfoDto infoDto = authUserQuery.queryForUser(phone);
        return new EntityDto<>(infoDto,CodeEnum.Success.getCode(),"成功");
    }


}
