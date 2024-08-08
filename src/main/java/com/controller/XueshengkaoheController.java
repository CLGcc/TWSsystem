package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XueshengkaoheEntity;
import com.entity.view.XueshengkaoheView;

import com.service.XueshengkaoheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生考核
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:13:00
 */
@RestController
@RequestMapping("/xueshengkaohe")
public class XueshengkaoheController {
    @Autowired
    private XueshengkaoheService xueshengkaoheService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengkaoheEntity xueshengkaohe,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengkaohe.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonggongbumen")) {
			xueshengkaohe.setBumenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengkaoheEntity> ew = new EntityWrapper<XueshengkaoheEntity>();

		PageUtils page = xueshengkaoheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengkaohe), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengkaoheEntity xueshengkaohe, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengkaohe.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonggongbumen")) {
			xueshengkaohe.setBumenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengkaoheEntity> ew = new EntityWrapper<XueshengkaoheEntity>();

		PageUtils page = xueshengkaoheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengkaohe), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengkaoheEntity xueshengkaohe){
       	EntityWrapper<XueshengkaoheEntity> ew = new EntityWrapper<XueshengkaoheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengkaohe, "xueshengkaohe")); 
        return R.ok().put("data", xueshengkaoheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengkaoheEntity xueshengkaohe){
        EntityWrapper< XueshengkaoheEntity> ew = new EntityWrapper< XueshengkaoheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengkaohe, "xueshengkaohe")); 
		XueshengkaoheView xueshengkaoheView =  xueshengkaoheService.selectView(ew);
		return R.ok("查询学生考核成功").put("data", xueshengkaoheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengkaoheEntity xueshengkaohe = xueshengkaoheService.selectById(id);
        return R.ok().put("data", xueshengkaohe);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengkaoheEntity xueshengkaohe = xueshengkaoheService.selectById(id);
        return R.ok().put("data", xueshengkaohe);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengkaoheEntity xueshengkaohe, HttpServletRequest request){
    	xueshengkaohe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengkaohe);
        xueshengkaoheService.insert(xueshengkaohe);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueshengkaoheEntity xueshengkaohe, HttpServletRequest request){
    	xueshengkaohe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengkaohe);
    	xueshengkaohe.setUserid((Long)request.getSession().getAttribute("userId"));
        xueshengkaoheService.insert(xueshengkaohe);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengkaoheEntity xueshengkaohe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengkaohe);
        xueshengkaoheService.updateById(xueshengkaohe);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengkaoheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XueshengkaoheEntity> wrapper = new EntityWrapper<XueshengkaoheEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonggongbumen")) {
			wrapper.eq("bumenzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = xueshengkaoheService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
