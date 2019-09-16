/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.test.entity.BaseOrg;
import com.jeesite.modules.test.entity.EchartsInfo;
import com.jeesite.modules.test.service.OrgInfoService;
import net.oschina.j2cache.util.FastjsonSerializer;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 组织机构Controller
 * @author zjb
 * @version 2019-08-04
 */
@Controller
@RequestMapping(value = "${adminPath}/org/orgInfo")
public class BicOrgController extends BaseController {

	@Autowired
	private OrgInfoService orgInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BaseOrg get(String id, boolean isNewRecord) {
		return orgInfoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("org_list")
	@RequestMapping(value = {"list", ""})
	public String list(BaseOrg baseOrg, Model model) {
		model.addAttribute("orgInfo", baseOrg);
		return "modules/org/orgInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("org_list")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BaseOrg> listData(BaseOrg baseOrg, HttpServletRequest request, HttpServletResponse response) {
		baseOrg.setPage(new Page<>(request, response));
		Page<BaseOrg> page = orgInfoService.findPage(baseOrg);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("org_list")
	@RequestMapping(value = "form")
	public String form(BaseOrg baseOrg, Model model) {
		model.addAttribute("orgInfo", baseOrg);
		return "modules/org/orgInfoForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("org_edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BaseOrg baseOrg) {
		if(baseOrg.getIsNewRecord()){
			baseOrg.setStatus("0");
			orgInfoService.save(baseOrg);
		}else{
			orgInfoService.update(baseOrg);
		}
		return renderResult(Global.TRUE, text("保存数据成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("org_edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(BaseOrg baseOrg) {
		baseOrg.setStatus(BaseOrg.STATUS_DISABLE);
		orgInfoService.updateStatus(baseOrg);
		return renderResult(Global.TRUE, text("停用数据成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("org_edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(BaseOrg baseOrg) {
		baseOrg.setStatus(BaseOrg.STATUS_NORMAL);
		orgInfoService.updateStatus(baseOrg);
		return renderResult(Global.TRUE, text("启用数据成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("org_delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BaseOrg baseOrg) {
		orgInfoService.delete(baseOrg);
		return renderResult(Global.TRUE, text("删除数据成功！"));
	}


	/**
	 * Echarts 图形展示
	 */
	@RequestMapping(value = "echarts")
	public String echarts(){

		return "modules/org/echarts";
	}


	/**
	 * Echarts 调用数据
	 */
	@RequestMapping(value = "findEcharts")
	@ResponseBody
	public Object  findEcharts(){

		List<EchartsInfo> resultInfo = orgInfoService.findEcharts();
		Map<String,Object>result=new HashMap<String,Object>();
		result.put("success", true);
		result.put("echartsInfo",resultInfo);
		return result;
	}

	/**
	 * EchartA 图形展示
	 */
	@RequestMapping(value = "echartA")
	public String echartA(){
		return "modules/org/echartA";
	}

	/**
	 * EchartB 图形展示
	 */
	@RequestMapping(value = "echartB")
	public String echartB(){
		return "modules/org/echartB";
	}

	/**
	 * EchartB 图形展示
	 */
	@RequestMapping(value = "echartC")
	public String echartC(){

		return "modules/org/echartC";
	}

	/**
	 * EchartB 图形展示
	 */
	@RequestMapping(value = "echartD")
	public String echartD(){

		return "modules/org/echartD";
	}
}
