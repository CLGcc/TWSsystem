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

import com.entity.GongzijiesuanEntity;
import com.entity.view.GongzijiesuanView;

import com.service.GongzijiesuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 工资结算
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:13:00
 */
@RestController
@RequestMapping("/gongzijiesuan")
public class GongzijiesuanController {
    @Autowired
    private GongzijiesuanService gongzijiesuanService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongzijiesuanEntity gongzijiesuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			gongzijiesuan.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonggongbumen")) {
			gongzijiesuan.setBumenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GongzijiesuanEntity> ew = new EntityWrapper<GongzijiesuanEntity>();

		PageUtils page = gongzijiesuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzijiesuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongzijiesuanEntity gongzijiesuan, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			gongzijiesuan.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonggongbumen")) {
			gongzijiesuan.setBumenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GongzijiesuanEntity> ew = new EntityWrapper<GongzijiesuanEntity>();

		PageUtils page = gongzijiesuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzijiesuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongzijiesuanEntity gongzijiesuan){
       	EntityWrapper<GongzijiesuanEntity> ew = new EntityWrapper<GongzijiesuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzijiesuan, "gongzijiesuan")); 
        return R.ok().put("data", gongzijiesuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzijiesuanEntity gongzijiesuan){
        EntityWrapper< GongzijiesuanEntity> ew = new EntityWrapper< GongzijiesuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzijiesuan, "gongzijiesuan")); 
		GongzijiesuanView gongzijiesuanView =  gongzijiesuanService.selectView(ew);
		return R.ok("查询工资结算成功").put("data", gongzijiesuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzijiesuanEntity gongzijiesuan = gongzijiesuanService.selectById(id);
        return R.ok().put("data", gongzijiesuan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzijiesuanEntity gongzijiesuan = gongzijiesuanService.selectById(id);
        return R.ok().put("data", gongzijiesuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongzijiesuanEntity gongzijiesuan, HttpServletRequest request){
    	gongzijiesuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzijiesuan);
        gongzijiesuanService.insert(gongzijiesuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongzijiesuanEntity gongzijiesuan, HttpServletRequest request){
    	gongzijiesuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzijiesuan);
    	gongzijiesuan.setUserid((Long)request.getSession().getAttribute("userId"));
        gongzijiesuanService.insert(gongzijiesuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongzijiesuanEntity gongzijiesuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzijiesuan);
        gongzijiesuanService.updateById(gongzijiesuan);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongzijiesuanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GongzijiesuanEntity> wrapper = new EntityWrapper<GongzijiesuanEntity>();
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

		int count = gongzijiesuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
