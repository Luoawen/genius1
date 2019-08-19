package com.career.genius.controller.wechat;

import javax.servlet.http.HttpServletRequest;

import com.career.genius.application.auth.dto.AuthUserInfoDto;
import com.career.genius.application.wechat.dto.WechatDto;
import com.career.genius.application.wechat.vo.WechatAuthVO;
import com.career.genius.application.wechat.vo.WechatShareVO;
import com.career.genius.config.Exception.GeniusException;
import com.career.genius.config.config.Config;
import com.career.genius.port.setvice.WxService;
import com.career.genius.utils.session.SessionUtil;
import com.career.genius.utils.wechat.WXUtil;
import com.career.genius.utils.wechat.WechatUtil;
import com.usm.enums.CodeEnum;
import com.usm.vo.EntityDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wechat")
@Api(tags = "微信")
public class WechatController {

    @ApiOperation(value = "获取微信access_token和签名")
    @GetMapping("/sgture")
    public EntityDto<WechatAuthVO> sgture(HttpServletRequest request) {
        String strUrl = request.getParameter("url");
        WechatDto wx = WechatUtil.getWinXinEntity(strUrl);
        // 将wx的信息到给页面
        String sgture = WXUtil.getSignature(wx.getTicket(), wx.getNoncestr(), wx.getTimestamp(), strUrl);
        WechatAuthVO result = new WechatAuthVO(sgture.trim(), wx.getTimestamp().trim(), wx.getNoncestr().trim(), Config.WX_APP_ID);
        return new EntityDto<>(result, CodeEnum.Success.getCode(),"成功");
    }

    @ApiOperation(value = "获取微信分享的url")
    @GetMapping("/url")
    public EntityDto<WechatShareVO> getWechatUrl(HttpServletRequest request) throws GeniusException {
        AuthUserInfoDto userInfo = SessionUtil.getSessionUser(request);
        WechatShareVO vo = new WechatShareVO(Config.WX_SHARE_URL, userInfo);
        return new EntityDto<>(vo, CodeEnum.Success.getCode(),"成功");
    }

    /*@GetMapping(value = "/share")
    public EntityDto<String> wechatOpen(String userId,HttpServletRequest request) {
        WxService.authorize()
        return new EntityDto<>("", CodeEnum.Success.getCode(),"成功");
    }*/






}