package com.career.genius.domain.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = -2300982649619939565L;

	@Id
	@Column(columnDefinition = "varchar(50) comment'id'")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Version
	protected Integer version = 0;

	@Column(name = "is_delete",columnDefinition = "tinyint(1) comment'删除标识(0-未删除,1-已删除)'")
	Boolean isDeleted = Boolean.valueOf(false);

	@Column(name = "create_time",columnDefinition = "datetime comment'创建时间'")
	private Date createTime;

	@Column(name = "update_time",columnDefinition = "datetime comment'更新时间'")
	private Date updateTime;

	@Column(name = "delete_time",columnDefinition = "datetime comment'删除时间'")
	private Date deleteTime;

	@Column(columnDefinition = "varchar(32) comment'创建者'")
	private String creater;

	@Column(columnDefinition = "varchar(32) comment'更新者'")
	private String updater;

	@Column(columnDefinition = "varchar(32) comment'删除者'")
	private String deletor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getDeletor() {
		return deletor;
	}

	public void setDeletor(String deletor) {
		this.deletor = deletor;
	}

}
