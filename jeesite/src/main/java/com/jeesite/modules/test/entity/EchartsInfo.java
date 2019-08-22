package com.jeesite.modules.test.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

@Table(name="bic_echart_info", alias="a", columns={
        @Column(name="id", attrName="id", label="编号", isPK=true),
        @Column(name="name_cn", attrName="name_cn", label="名称", queryType= QueryType.LIKE),
        @Column(name="valueInfo", attrName="valueInfo", label="值", queryType=QueryType.LIKE),
        @Column(name="status", attrName="status", label="单行文本")
}

)

public class EchartsInfo extends DataEntity<EchartsInfo> {
    private String nameCn;  // 名称
    private String valueInfo;   // 值
    private String status;     // 状态

    public String getValueInfo() {
        return valueInfo;
    }

    public void setValueInfo(String valueInfo) {
        this.valueInfo = valueInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }
}
