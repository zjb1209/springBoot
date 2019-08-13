/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.service;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.file.utils.FileUploadUtils;
import com.jeesite.modules.test.dao.BaseOrgDao;
import com.jeesite.modules.test.dao.TestDataChildDao;
import com.jeesite.modules.test.entity.BaseOrg;
import com.jeesite.modules.test.entity.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
 * 测试树表Service
 * @author ThinkGem
 * @version 2018-04-22
 */
@Service
@Transactional(readOnly=true)
public class OrgInfoService extends CrudService<BaseOrgDao,BaseOrg> {

	@Autowired
	private BaseOrgDao baseOrgDao;

	/**
	 * 获取单条数据
	 * @param baseOrg
	 * @return
	 */
	@Override
	public BaseOrg get(BaseOrg baseOrg) {
		
		return super.get(baseOrg);
	}



	/**
	 * 查询列表数据
	 * @param baseOrg
	 * @return
	 */
	@Override
	public Page findPage(BaseOrg baseOrg) {
		Page page=new Page<BaseOrg>();
		page.setList(baseOrgDao.findList(baseOrg));
		page.setCount(baseOrgDao.findCount(baseOrg));
		return page;
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param baseOrg
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(BaseOrg baseOrg) {
		super.save(baseOrg);
	}
	
	/**
	 * 更新状态
	 * @param baseOrg
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(BaseOrg baseOrg) {
		baseOrgDao.updateStatus(baseOrg);
	}
	
	/**
	 * 删除数据
	 * @param baseOrg
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(BaseOrg baseOrg) {
		baseOrgDao.delete(baseOrg);
	}
	
}