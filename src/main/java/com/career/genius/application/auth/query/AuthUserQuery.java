package com.career.genius.application.auth.query;

import com.career.genius.application.auth.dto.AuthUserInfoDto;
import com.career.genius.config.Exception.GeniusException;
import com.career.genius.utils.jdbcframework.SupportJdbcTemplate;
import com.usm.utils.ObjectHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-05-31 15:20
 * @discription
 **/
@Repository
@Slf4j
public class AuthUserQuery {

    @Autowired
    SupportJdbcTemplate supportJdbcTemplate;

    public AuthUserInfoDto queryForUser(String phone) throws GeniusException {
        if (ObjectHelper.isEmpty(phone)) {
            throw new GeniusException("手机号为空");
        }

        String sql = " SELECT id, user_name, head_image, open_id, phone FROM app_user WHERE phone = ? ";

        AuthUserInfoDto infoDto = this.supportJdbcTemplate.queryForDto(sql, AuthUserInfoDto.class, phone);
        if (null == infoDto) {
            throw new GeniusException("用户不存在");
        }
        return infoDto;
    }

}
