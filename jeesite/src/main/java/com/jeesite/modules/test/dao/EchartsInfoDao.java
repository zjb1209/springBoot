/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.dao;
import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.test.entity.BaseOrg;
import com.jeesite.modules.test.entity.EchartsInfo;

import java.util.List;
import java.util.Map;

/**
 * 测试数据DAO接口
 * @author ThinkGem
 * @version 2018-04-22
 */
@MyBatisDao
public interface EchartsInfoDao extends CrudDao<EchartsInfo> {

        List<EchartsInfo>  findEcharts();
}