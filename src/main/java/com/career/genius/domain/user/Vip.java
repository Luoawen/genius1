package com.career.genius.domain.user;

import com.career.genius.domain.common.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-06-28 14:18
 * @discription
 **/
@Entity
@Data
@Table(name = "app_vip")
public class Vip extends BaseEntity {

    private String userId;




}
