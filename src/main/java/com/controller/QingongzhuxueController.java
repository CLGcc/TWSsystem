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

import com.entity.QingongzhuxueEntity;
import com.entity.view.QingongzhuxueView;

import com.service.QingongzhuxueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 勤工助学
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 13:13:00
 */
@RestController
@RequestMapping("/qingongzhuxue")
public class QingongzhuxueController {
    @Autowired
    private QingongzhuxueService qingongzhuxueService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QingongzhuxueEntity qingongzhuxue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonggongbumen")) {
			qingongzhuxue.setBumenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QingongzhuxueEntity> ew = new EntityWrapper<QingongzhuxueEntity>();

		PageUtils page = qingongzhuxueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingongzhuxue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QingongzhuxueEntity qingongzhuxue, 
		HttpServletRequest request){
        EntityWrapper<QingongzhuxueEntity> ew = new EntityWrapper<QingongzhuxueEntity>();

		PageUtils page = qingongzhuxueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingongzhuxue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QingongzhuxueEntity qingongzhuxue){
       	EntityWrapper<QingongzhuxueEntity> ew = new EntityWrapper<QingongzhuxueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qingongzhuxue, "qingongzhuxue")); 
        return R.ok().put("data", qingongzhuxueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QingongzhuxueEntity qingongzhuxue){
        EntityWrapper< QingongzhuxueEntity> ew = new EntityWrapper< QingongzhuxueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qingongzhuxue, "qingongzhuxue")); 
		QingongzhuxueView qingongzhuxueView =  qingongzhuxueService.selectView(ew);
		return R.ok("查询勤工助学成功").put("data", qingongzhuxueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QingongzhuxueEntity qingongzhuxue = qingongzhuxueService.selectById(id);
		qingongzhuxue.setClicknum(qingongzhuxue.getClicknum()+1);
		qingongzhuxue.setClicktime(new Date());
		qingongzhuxueService.updateById(qingongzhuxue);
        return R.ok().put("data", qingongzhuxue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QingongzhuxueEntity qingongzhuxue = qingongzhuxueService.selectById(id);
		qingongzhuxue.setClicknum(qingongzhuxue.getClicknum()+1);
		qingongzhuxue.setClicktime(new Date());
		qingongzhuxueService.updateById(qingongzhuxue);
        return R.ok().put("data", qingongzhuxue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QingongzhuxueEntity qingongzhuxue, HttpServletRequest request){
    	qingongzhuxue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qingongzhuxue);
        qingongzhuxueService.insert(qingongzhuxue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QingongzhuxueEntity qingongzhuxue, HttpServletRequest request){
    	qingongzhuxue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qingongzhuxue);
        qingongzhuxueService.insert(qingongzhuxue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QingongzhuxueEntity qingongzhuxue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qingongzhuxue);
        qingongzhuxueService.updateById(qingongzhuxue);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qingongzhuxueService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<QingongzhuxueEntity> wrapper = new EntityWrapper<QingongzhuxueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonggongbumen")) {
			wrapper.eq("bumenzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = qingongzhuxueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,QingongzhuxueEntity qingongzhuxue, HttpServletRequest request,String pre){
        EntityWrapper<QingongzhuxueEntity> ew = new EntityWrapper<QingongzhuxueEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = qingongzhuxueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingongzhuxue), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,QingongzhuxueEntity qingongzhuxue, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "gangweileixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "qingongzhuxue").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<QingongzhuxueEntity> qingongzhuxueList = new ArrayList<QingongzhuxueEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                qingongzhuxueList.addAll(qingongzhuxueService.selectList(new EntityWrapper<QingongzhuxueEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<QingongzhuxueEntity> ew = new EntityWrapper<QingongzhuxueEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = qingongzhuxueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingongzhuxue), params), params));
        List<QingongzhuxueEntity> pageList = (List<QingongzhuxueEntity>)page.getList();
        if(qingongzhuxueList.size()<limit) {
            int toAddNum = (limit-qingongzhuxueList.size())<=pageList.size()?(limit-qingongzhuxueList.size()):pageList.size();
            for(QingongzhuxueEntity o1 : pageList) {
                boolean addFlag = true;
                for(QingongzhuxueEntity o2 : qingongzhuxueList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    qingongzhuxueList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(qingongzhuxueList.size()>limit) {
            qingongzhuxueList = qingongzhuxueList.subList(0, limit);
        }
        page.setList(qingongzhuxueList);
        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<QingongzhuxueEntity> ew = new EntityWrapper<QingongzhuxueEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonggongbumen")) {
            ew.eq("bumenzhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = qingongzhuxueService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<QingongzhuxueEntity> ew = new EntityWrapper<QingongzhuxueEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonggongbumen")) {
            ew.eq("bumenzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = qingongzhuxueService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<QingongzhuxueEntity> ew = new EntityWrapper<QingongzhuxueEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonggongbumen")) {
            ew.eq("bumenzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = qingongzhuxueService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }






}
