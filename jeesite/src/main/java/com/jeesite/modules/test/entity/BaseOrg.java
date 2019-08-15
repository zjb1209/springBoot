/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.entity;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


/**
 * 组织机构Entity
 * @author zjb
 * @version 2019-08-04
 */
@Table(name="bic_base_org", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="code", attrName="code", label="单行文本", queryType=QueryType.LIKE),
		@Column(name="name_cn", attrName="nameCn", label="单行文本", queryType=QueryType.LIKE),
		@Column(name="postcode", attrName="postCode", label="单行文本"),
		@Column(name="administrative_division", attrName="administrativeDivision", label="单行文本"),
		@Column(name="status", attrName="status", label="单行文本")
	}

)
public class BaseOrg extends DataEntity<BaseOrg> {

	private static final long serialVersionUID = 1L;
	private String code;		// 单行文本
	private String nameCn;		// 单行文本
	private String postCode;		// 单行文本
	private String administrativeDivision;		// 单行文本
	private Long createUserId;
	private Date gmtCreated;
    private Long modifyUserId;
    private Date gmtModified;


	public BaseOrg() {
		this(null);
	}

	public BaseOrg(String id){
		super(id);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Length(min=0, max=20, message="多行文本长度不能超过 20 个字符")
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Length(min=0, max=20, message="多行文本长度不能超过 20 个字符")
	public String getAdministrativeDivision() {
		return administrativeDivision;
	}

	public void setAdministrativeDivision(String administrativeDivision) {
		this.administrativeDivision = administrativeDivision;
	}

	@Length(min=0, max=20, message="多行文本长度不能超过 20 个字符")
	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Long getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(Long modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public Date getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}


}