package com.career.genius.utils.session;

import com.career.genius.application.auth.dto.AuthUserInfoDto;
import com.career.genius.config.Exception.GeniusException;
import com.usm.utils.ObjectHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-07-16 14:08
 * @discription
 **/
public class SessionUtil {

    public static AuthUserInfoDto getSessionUser(HttpServletRequest request) throws GeniusException {
        HttpSession session = request.getSession();
        AuthUserInfoDto userInfo = (AuthUserInfoDto) session.getAttribute("userInfo");
        if (ObjectHelper.isEmpty(userInfo)) {
            throw new GeniusException("请重新登陆!");
        }
        return userInfo;
    }
}
