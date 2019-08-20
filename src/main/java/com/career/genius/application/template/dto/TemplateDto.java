package com.career.genius.application.template.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-06-19 14:30
 * @discription
 **/
@Data
@ApiModel("模板请求参数")
public class TemplateDto {

    @ApiModelProperty(value = "模板ID")
    private String templateId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "模板内容")
    private String content;

    @ApiModelProperty(value = "当前用户ID")
    private String userId;

    @ApiModelProperty(value = "分享路径")
    private String url;

}
