package com.career.genius.domain.template;

import com.career.genius.domain.common.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-08-20 08:57
 * @discription
 **/
@Data
@Table(name = "template_views")
public class TemplateViews extends BaseEntity {

    @Column(name = "template_id",columnDefinition = "varchar(32) comment'模板ID'")
    private String templateId;

    @Column(name = "view_user_openid",columnDefinition = "varchar(50) comment'浏览者openId'")
    private String viewUserOpenId;

    @Column(name = "view_user_name",columnDefinition = "varchar(50) comment'浏览者姓名'")
    private String viewUserName;

    @Column(name = "view_user_head_image",columnDefinition = "varchar(50) comment'浏览者头像'")
    private String viewUserHeadImage;

    @Column(name = "view_times",columnDefinition = "int comment'浏览时常'")
    private long viewTimes;

    public void addViewInfo(String templateId,String viewUserOpenId,String viewUserName,String viewUserHeadImage) {
        this.templateId = templateId;
        this.viewUserOpenId = viewUserOpenId;
        this.viewUserName = viewUserName;
        this.viewUserHeadImage = viewUserHeadImage;
        super.setCreateTime(new Date());
        super.setUpdateTime(new Date());
    }
}
