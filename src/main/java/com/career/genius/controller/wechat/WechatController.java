package com.career.genius.controller.wechat;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.career.genius.application.auth.dao.AuthUserInfoDto;
import com.career.genius.application.wechat.dto.WechatDto;
import com.career.genius.config.Exception.GeniusException;
import com.career.genius.config.config.Config;
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
    public EntityDto<Map<String, Object>> sgture(HttpServletRequest request) {
        String strUrl = request.getParameter("url");
        WechatDto wx = WechatUtil.getWinXinEntity(strUrl);
        // 将wx的信息到给页面
        Map<String, Object> map = new HashMap<String, Object>();
        String sgture = WXUtil.getSignature(wx.getTicket(), wx.getNoncestr(), wx.getTimestamp(), strUrl);
        map.put("sgture", sgture.trim());//签名
        map.put("timestamp", wx.getTimestamp().trim());//时间戳
        map.put("noncestr", wx.getNoncestr().trim());//随即串
        map.put("appid", Config.WX_APP_ID);//appID
        return new EntityDto<>(map, CodeEnum.Success.getCode(),"成功");
    }

    @ApiOperation(value = "获取微信分享的url")
    @GetMapping("/url")
    public EntityDto<Map<String, Object>> getWechatUrl(HttpServletRequest request) throws GeniusException {
        AuthUserInfoDto userInfo = SessionUtil.getSessionUser(request);
        Map<String, Object> result = new HashMap<>();
        result.put("url",Config.WX_SHARE_URL);
        result.put("userInfo",userInfo);
        return new EntityDto<>(result, CodeEnum.Success.getCode(),"成功");
    }




}